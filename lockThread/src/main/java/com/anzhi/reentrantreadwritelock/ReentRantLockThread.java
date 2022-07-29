package com.anzhi.reentrantreadwritelock;

public class ReentRantLockThread implements Runnable{

    private ReentrantLockDemo reentrantLockDemo;

    public ReentRantLockThread(ReentrantLockDemo reentrantLockDemo) {
        this.reentrantLockDemo = reentrantLockDemo;
    }

    @Override
    public void run() {
        reentrantLockDemo.testMethod();
    }
}
