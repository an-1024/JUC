package com.anzhi.lockmethodsuse;

import java.util.concurrent.locks.ReentrantLock;

public class GetholdCountMethodDemo {
    private ReentrantLock lock = new ReentrantLock(true);

    public void lockMethod1(){
        System.out.println("A " + lock.getHoldCount());
        lock.lock();;
        System.out.println("B " + lock.getHoldCount());
        lockMethod2();
        System.out.println("F " + lock.getHoldCount());
        lock.unlock();
        System.out.println("G " + lock.getHoldCount());
    }

    public void lockMethod2(){
        System.out.println("C " + lock.getHoldCount());
        lock.lock();;
        System.out.println("D " + lock.getHoldCount());
        lock.unlock();
        System.out.println("E " + lock.getHoldCount());

    }
}
