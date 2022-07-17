package com.anzhi.reentrantlockuse;

public class MyReentRantLockThreadTest {
    public static void main(String[] args) {
        MyReentRantLockService myReentRantLockService = new MyReentRantLockService();
        
        for (int i=0; i<2; i++){
            MyReentRantLockThread myReentRantLockThread = new MyReentRantLockThread(myReentRantLockService);
            Thread t1 = new Thread(myReentRantLockThread);
            t1.setName("Thread=" + i);
            t1.start();
        }
    }
}
