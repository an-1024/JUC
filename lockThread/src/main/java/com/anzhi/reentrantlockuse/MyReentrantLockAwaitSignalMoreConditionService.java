package com.anzhi.reentrantlockuse;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class MyReentrantLockAwaitSignalMoreConditionService {
    private Lock lock = new ReentrantLock();
    
    public Condition conditionA = lock.newCondition();
    public Condition conditionB = lock.newCondition();
    
    public void awaitMethodA(){
        lock.lock();
        System.out.println("begin awaitMethodA 时间为" + System.currentTimeMillis() + " ThreadName = " + Thread.currentThread().getName());
        try {
            conditionA.await();
            System.out.println("  endi awaitA时间为" + System.currentTimeMillis() + " ThreadName = " + Thread.currentThread().getName());
        } catch (InterruptedException e) {
            // doNothing
        }finally {
            lock.unlock();
        }
    }
    
    public void awaitMethodB(){
        lock.lock();
        System.out.println("begin awaitMethodB 时间为" + System.currentTimeMillis() + " ThreadName = " + Thread.currentThread().getName());
        try {
            conditionB.await();
            System.out.println("  endi awaitB时间为" + System.currentTimeMillis() + " ThreadName = " + Thread.currentThread().getName());
        } catch (InterruptedException e) {
            // doNothing
        }finally {
            lock.unlock();
        }
    }
    
    public void signalAll_A(){
        lock.lock();
        System.out.println("     signalAll_A 时间为" + System.currentTimeMillis() + " ThreadName = " + Thread.currentThread().getName());
        try {
            conditionA.signalAll();
        } catch (Exception e) {
            // doNothing
        }finally {
            lock.unlock();
        }
    }

    public void signalAll_B(){
        lock.lock();
        System.out.println("     signalAll_B 时间为" + System.currentTimeMillis() + " ThreadName = " + Thread.currentThread().getName());
        try {
            conditionB.signalAll();
        } catch (Exception e) {
            // doNothing
        }finally {
            lock.unlock();
        }
    }
    
}
