package com.anzhi.reentrantreadwritelock;

import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ReentrantReadWriteLockMultDemoTest {
    public static void main(String[] args) {
        ReentrantReadWriteLockMultDemo readWriteLockMultDemo = new ReentrantReadWriteLockMultDemo();
        ReentrantReadWriteLockReadMultThread readMultThread = new ReentrantReadWriteLockReadMultThread(readWriteLockMultDemo);
        Thread t1 = new Thread(readMultThread);
        t1.start();

        ReentrantReadWriteLockWriteMultThread writeLockWriteMultThread = new ReentrantReadWriteLockWriteMultThread(readWriteLockMultDemo);
        Thread t2 = new Thread(writeLockWriteMultThread);
        t2.start();
    }
}
