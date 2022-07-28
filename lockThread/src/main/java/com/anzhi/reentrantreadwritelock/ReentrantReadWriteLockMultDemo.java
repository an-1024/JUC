package com.anzhi.reentrantreadwritelock;

import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ReentrantReadWriteLockMultDemo {
    private ReentrantReadWriteLock readWriteLock = new ReentrantReadWriteLock();

    public void read(){
        try {
            readWriteLock.readLock().lock();
            System.out.println("获得读锁" + Thread.currentThread().getName() + " " + System.currentTimeMillis());
            Thread.sleep(10000);
        } catch (Exception e){
            // doNothing
        } finally {
            readWriteLock.readLock().unlock();
        }
    }


    public void write(){
        try{
            readWriteLock.writeLock().lock();
            System.out.println("获得写锁" + Thread.currentThread().getName() + " " + System.currentTimeMillis());
            Thread.sleep(10000);
        }catch (Exception e){
            // doNothing
        }finally {
            readWriteLock.writeLock().unlock();
        }
    }
}
