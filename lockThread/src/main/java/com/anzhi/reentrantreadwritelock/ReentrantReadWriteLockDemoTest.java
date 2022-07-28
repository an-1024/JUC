package com.anzhi.reentrantreadwritelock;

import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ReentrantReadWriteLockDemoTest {
    private ReentrantReadWriteLock readWriteLock = new ReentrantReadWriteLock();
    private String userName = "abc";

    public void tetMethod(){
        try{
            readWriteLock.readLock().lock();
            System.out.println("begin " + Thread.currentThread().getName() + " " + System.currentTimeMillis());
            System.out.println("print service " + userName);
            Thread.sleep(4000);
            System.out.println("    end " + Thread.currentThread().getName() + " " + System.currentTimeMillis());
        }catch (Exception e){
            // doNothing
        }finally {
            readWriteLock.readLock().unlock();
        }
    }
}
