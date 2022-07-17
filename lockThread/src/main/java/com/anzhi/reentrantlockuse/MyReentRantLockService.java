package com.anzhi.reentrantlockuse;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class MyReentRantLockService {
    private Lock lock = new ReentrantLock();
    
    public void reentrantLockService(){
        // 加锁
        lock.lock();
        for (int i=0; i<5; i++){
            System.out.println("ThreadName = " + Thread.currentThread().getName() + (" " + (i + 1)));
        }
        // 释放锁
        lock.unlock();
    }
}
