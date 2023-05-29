package com.anzhi.aqsdemo;

import java.util.concurrent.locks.AbstractQueuedSynchronizer;

public class LockAQSSolutionDemo extends AbstractQueuedSynchronizer {
    @Override
    protected boolean tryAcquire(int arg) {
        // cas 加锁 state = 0;
        if (compareAndSetState(0, 1)) {
            setExclusiveOwnerThread(Thread.currentThread());
            return true;
        }
        return false;
    }

    @Override
    protected boolean tryRelease(int arg) {
        //释放锁
        setExclusiveOwnerThread(null);
        setState(0);
        return true;
    }
    
    public void lock () {
        acquire(1);
    }
    
    public void unlock () {
        release(1);
    }
    
    public boolean tryLock () {
        return tryAcquire(1);
    }
    
    public boolean isLocked () {
        return isHeldExclusively();
    }

    private final static LockAQSSolutionDemo lockAQSSolutionDemo = new LockAQSSolutionDemo();
    private static int count = 0;

    public static void addCount () {
        lockAQSSolutionDemo.lock();
        try {
            count++;
        } finally {
            lockAQSSolutionDemo.unlock();
        }
    }

    public static void main(String[] args) {
        Thread t1 = new Thread(() -> {
            for (int i=0; i<5000; i++) {
                addCount();
            }
        }, "t1");

        Thread t2 = new Thread(() -> {
            for (int i=0; i<5000; i++) {
                addCount();
            }
        }, "t2");

        t1.start();
        t2.start();
        try {
            t1.join();
            t2.join();
        } catch (Exception e) {
            // doSomething
        }
        System.out.println(count);
    }
}
