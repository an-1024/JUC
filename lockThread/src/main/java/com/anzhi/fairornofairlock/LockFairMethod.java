package com.anzhi.fairornofairlock;

import java.util.concurrent.locks.ReentrantLock;

public class LockFairMethod {
    private ReentrantLock lock;

    public LockFairMethod(boolean isFair) {
        lock = new ReentrantLock(isFair);
    }

    public void lockMethodService(){
        try{
            lock.lock();
            System.out.println("ThreadName= " + Thread.currentThread().getName() + " 获得锁定");
        }finally {
            lock.unlock();
        }
    }
}
