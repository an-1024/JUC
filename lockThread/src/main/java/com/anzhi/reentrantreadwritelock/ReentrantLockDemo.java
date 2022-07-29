package com.anzhi.reentrantreadwritelock;

import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockDemo {
    private ReentrantLock lock = new ReentrantLock();
    private String username = "abc";

    public void testMethod(){
        try{
            lock.lock();
            System.out.println("begin " + Thread.currentThread().getName() + " " + System.currentTimeMillis());
            System.out.println("print service " + username);
            Thread.sleep(4000);
            System.out.println("    end " + Thread.currentThread().getName() + " " + System.currentTimeMillis());
            lock.unlock();
        }catch (Exception e){
            // doNothing
        }
    }
}
