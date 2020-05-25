package mscorlib;

import system.timers.ElapsedEventHandler;

public class TimerElapsed extends ElapsedEventHandler {
    public void Invoke(org.mases.jcobridge.netreflection.NetObject arg0, system.timers.ElapsedEventArgs arg1) {
        try {
            System.out.println(String.format("Timer elapsed at %s", arg1.getSignalTime().toString()));
        } catch (Throwable e) {
            e.printStackTrace();
        }
    }
}