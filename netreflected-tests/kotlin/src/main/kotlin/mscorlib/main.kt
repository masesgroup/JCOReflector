package mscorlib;

import system.*;

fun main(args: Array<String>) {
    for (name in Environment.GetLogicalDrives()) {
        Console.WriteLine(name)
    }
}