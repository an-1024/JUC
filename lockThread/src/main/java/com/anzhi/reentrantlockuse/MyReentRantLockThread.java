package com.anzhi.reentrantlockuse;

public class MyReentRantLockThread implements Runnable{
    
    private MyReentRantLockService myReentRantLockService;

    public MyReentRantLockThread(MyReentRantLockService myReentRantLockService) {
        this.myReentRantLockService = myReentRantLockService;
    }

    public void run() {
        myReentRantLockService.reentrantLockService();
    }
}
