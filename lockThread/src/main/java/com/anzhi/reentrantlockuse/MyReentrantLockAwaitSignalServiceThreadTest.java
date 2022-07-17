package com.anzhi.reentrantlockuse;

public class MyReentrantLockAwaitSignalServiceThreadTest {
    public static void main(String[] args) {

        MyReentrantLockAwaitSignalService awaitSignalService = new MyReentrantLockAwaitSignalService();

        Thread thread = new Thread(new MyReentrantLockAwaitSignalServiceThread(awaitSignalService));
        thread.setName("t1");
        thread.start();

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            // doNothing
        }
        
        awaitSignalService.signalMethod();
    }
}
