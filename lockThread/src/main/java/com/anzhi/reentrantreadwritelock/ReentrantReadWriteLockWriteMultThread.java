package com.anzhi.reentrantreadwritelock;

public class ReentrantReadWriteLockWriteMultThread implements Runnable {

    private ReentrantReadWriteLockMultDemo readWriteLockMultDemo;

    public ReentrantReadWriteLockWriteMultThread(ReentrantReadWriteLockMultDemo readWriteLockMultDemo) {
        this.readWriteLockMultDemo = readWriteLockMultDemo;
    }

    @Override
    public void run() {
        readWriteLockMultDemo.write();
    }
}
