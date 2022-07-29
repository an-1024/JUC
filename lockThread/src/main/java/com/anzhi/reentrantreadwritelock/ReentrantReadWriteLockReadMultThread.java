package com.anzhi.reentrantreadwritelock;

public class ReentrantReadWriteLockReadMultThread implements Runnable {

    private ReentrantReadWriteLockMultDemo readWriteLockMultDemo;

    public ReentrantReadWriteLockReadMultThread(ReentrantReadWriteLockMultDemo readWriteLockMultDemo) {
        this.readWriteLockMultDemo = readWriteLockMultDemo;
    }

    @Override
    public void run() {
        readWriteLockMultDemo.read();
    }
}
