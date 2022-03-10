$bytes = [Convert]::FromBase64String($args[0])
[IO.File]::WriteAllBytes($args[1], $bytes)