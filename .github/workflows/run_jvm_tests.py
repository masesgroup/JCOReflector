#!/usr/bin/env python3
"""Run the JVM tests listed in jvm_tests.list for one language on the current OS.

Replaces the dozens of repeated "- run: java -cp ... <class>" steps in each job:
the job prepares its environment (different for every language/OS combination)
and then launches this script, which reads the single shared list of tests.

Configuration (environment variables, or the matching command-line options):
  TESTS_LANG       java | scala | kotlin | clojure
  TESTS_RUNNER     command that launches ONE test, without the class name.
                   Example: java -cp "./bin/net10.0/JCOReflector.jar:./tests/jvm/java/src/"
                   For every entry of the list the script runs
                   "<TESTS_RUNNER> <class> [arguments]".
  RUNNER_OS        Windows | Linux | macOS (set by GitHub Actions)
  FORCE_EXECUTION  "true" => failures never stop the job (same as the old
                   "continue-on-error: ${{ inputs.ForceExecution }}" on every step).
                   Otherwise the first failing test stops the run and fails the
                   step, as before.
  TESTS_LIST       (optional) path of the list; default: jvm_tests.list next to
                   this script.

Every command runs in the native shell of the OS: cmd.exe on Windows, bash on
Linux/macOS. So ".\\bin\\scala\\bin\\scala" or "source sdkman-init.sh && scala"
behave exactly as in the original "run:" steps.

Try it locally without executing anything:
  python run_jvm_tests.py --lang java --os linux --runner 'java -cp "a:b"' --dry-run

Exit codes: 0 ok (or failures ignored by FORCE_EXECUTION), 1 a test failed,
2 configuration or list syntax error.
"""
import argparse
import os
import subprocess
import sys
import time
from pathlib import Path

LANGS = {"java", "scala", "kotlin", "clojure"}
OSES = {"windows", "linux", "macos"}
KNOWN_TAGS = LANGS | OSES


def die(message):
    print(f"::error title=run_jvm_tests::{message}", flush=True)
    sys.exit(2)


def load_specs(list_path, tags):
    """Return the 'class [arguments]' entries that apply to the given set of tags."""
    specs = []
    try:
        text = list_path.read_text(encoding="utf-8")
    except OSError as exc:
        die(f"cannot read test list {list_path}: {exc}")
    for number, raw in enumerate(text.splitlines(), 1):  # handles both LF and CRLF
        line = raw.split("#", 1)[0].strip()
        if not line:
            continue
        if line.startswith("["):
            end = line.find("]")
            if end < 0:
                die(f"{list_path.name}:{number}: missing ']' in filter")
            terms = [t.strip() for t in line[1:end].split(",") if t.strip()]
            spec = line[end + 1:].strip()
            for term in terms:
                if term.lstrip("!") not in KNOWN_TAGS:
                    die(f"{list_path.name}:{number}: unknown tag '{term}' "
                        f"(valid: {', '.join(sorted(KNOWN_TAGS))})")
            selected = all(
                (term[1:] not in tags) if term.startswith("!") else (term in tags)
                for term in terms
            )
            if not selected:
                continue
        else:
            spec = line
        if not spec:
            die(f"{list_path.name}:{number}: filter without a test")
        specs.append(spec)
    return specs


def run_in_native_shell(command):
    # shell=True: cmd.exe on Windows, /bin/bash on Linux/macOS (like a "run:" step)
    if os.name == "nt":
        return subprocess.run(command, shell=True).returncode
    return subprocess.run(command, shell=True, executable="/bin/bash").returncode


def write_summary(title, rows, counts):
    path = os.environ.get("GITHUB_STEP_SUMMARY")
    if not path:
        return
    passed, failed, skipped = counts
    out = [f"### {title}: {passed} passed, {failed} failed, {skipped} not run", "",
           "| # | Test | Result | Duration |", "|---:|---|:---:|---:|"]
    for index, spec, status, seconds in rows:
        out.append(f"| {index} | `{spec}` | {status} | {seconds}s |")
    with open(path, "a", encoding="utf-8") as handle:
        handle.write("\n".join(out) + "\n\n")


def main():
    parser = argparse.ArgumentParser(description=__doc__.split("\n")[0])
    parser.add_argument("--lang", default=os.environ.get("TESTS_LANG"))
    parser.add_argument("--os", dest="os_name",
                        default=os.environ.get("RUNNER_OS", "").lower())
    parser.add_argument("--runner", default=os.environ.get("TESTS_RUNNER"))
    parser.add_argument("--list", dest="list_path",
                        default=os.environ.get("TESTS_LIST"))
    parser.add_argument("--dry-run", action="store_true",
                        help="print the commands without running them")
    args = parser.parse_args()

    if hasattr(sys.stdout, "reconfigure"):  # avoid encoding errors on Windows
        sys.stdout.reconfigure(encoding="utf-8", errors="replace")

    lang = (args.lang or "").lower()
    os_name = (args.os_name or "").lower()
    if lang not in LANGS:
        die(f"TESTS_LANG/--lang must be one of {sorted(LANGS)}, got '{lang}'")
    if os_name not in OSES:
        die(f"RUNNER_OS/--os must be one of {sorted(OSES)}, got '{os_name}'")
    if not args.runner:
        die("TESTS_RUNNER/--runner is not set")

    force = os.environ.get("FORCE_EXECUTION", "").lower() == "true"
    list_path = Path(args.list_path) if args.list_path \
        else Path(__file__).resolve().with_name("jvm_tests.list")

    specs = load_specs(list_path, {lang, os_name})
    if not specs:
        die(f"no test selected for {lang}/{os_name} in {list_path.name}")
    for spec in sorted({s for s in specs if specs.count(s) > 1}):
        print(f"::warning title=run_jvm_tests::duplicate test in the list: {spec}",
              flush=True)

    total = len(specs)
    print(f"{total} tests to run for {lang} on {os_name}"
          f"{' (FORCE_EXECUTION: failures do not stop the job)' if force else ''}",
          flush=True)

    rows, passed, failed = [], 0, 0
    for index, spec in enumerate(specs, 1):
        command = f"{args.runner} {spec}"
        if args.dry_run:
            print(command)
            continue
        # The group title doubles as the "started" banner: it stays visible
        # even when the group is collapsed in the GitHub log.
        print(f"::group::====== [{index}/{total}] {spec} started ======", flush=True)
        print(f"$ {command}", flush=True)
        started = time.monotonic()
        code = run_in_native_shell(command)
        seconds = round(time.monotonic() - started)
        verdict = "PASSED" if code == 0 else f"FAILED (exit code {code})"
        print(f"====== [{index}/{total}] {spec} finished: {verdict} in {seconds}s ======",
              flush=True)
        print("::endgroup::", flush=True)
        if code == 0:
            passed += 1
            rows.append((index, spec, "PASSED", seconds))
            continue
        failed += 1
        rows.append((index, spec, "FAILED", seconds))
        level = "warning" if force else "error"
        print(f"::{level} title=Test failed::{spec} (exit code {code})", flush=True)
        if not force:
            break  # as before: without ForceExecution the first failure stops the job

    if args.dry_run:
        return 0

    skipped = total - len(rows)
    for index in range(len(rows) + 1, total + 1):
        rows.append((index, specs[index - 1], "not run", 0))
    write_summary(f"{lang} / {os_name}", rows, (passed, failed, skipped))
    print(f"Result: {passed} passed, {failed} failed, {skipped} not run", flush=True)
    return 1 if failed and not force else 0


if __name__ == "__main__":
    sys.exit(main())
