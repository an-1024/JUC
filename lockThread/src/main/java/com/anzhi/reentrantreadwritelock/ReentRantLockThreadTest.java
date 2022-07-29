package com.anzhi.reentrantreadwritelock;

public class ReentRantLockThreadTest {
    public static void main(String[] args) {
        ReentrantLockDemo reentrantLockDemo = new ReentrantLockDemo();
        ReentRantLockThread reentRantLockThread = new ReentRantLockThread(reentrantLockDemo);
        Thread t1 = new Thread(reentRantLockThread);
        t1.start();

        Thread t2 = new Thread(reentRantLockThread);
        t2.start();
    }
}
