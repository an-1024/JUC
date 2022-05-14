package com.anzhi.threadmethod.stopthread.stopreleaselock;

public class StopReleaseLockThreadA extends Thread{

    private StopReleaseLockService serviceThread;

    public StopReleaseLockThreadA(StopReleaseLockService serviceThread) {
        this.serviceThread = serviceThread;
    }

    @Override
    public void run() {
        serviceThread.printString("b", "bb");
    }
}
