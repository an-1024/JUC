package com.anzhi.threadmethod.stopthread.stopreleaselock;

public class StopReleaseLockThreadB extends Thread{

    private StopReleaseLockService serviceThread;

    public StopReleaseLockThreadB(StopReleaseLockService serviceThread) {
        this.serviceThread = serviceThread;
    }

    @Override
    public void run() {
        System.out.println("username=" + serviceThread.getUsername());
        System.out.println("password=" + serviceThread.getPassword());
    }
}
