package com.anzhi.reentrantlockuse;

public class MyReentrantLockAwaitSignalServiceThread implements Runnable{
    
    private MyReentrantLockAwaitSignalService awaitSignalService;

    public MyReentrantLockAwaitSignalServiceThread(MyReentrantLockAwaitSignalService awaitSignalService) {
        this.awaitSignalService = awaitSignalService;
    }

    @Override
    public void run() {
        awaitSignalService.awaitMethod();
    }
}
