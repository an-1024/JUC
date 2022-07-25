package com.anzhi.reentrantlockconsumerproducer;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class MyReentrantLockConditionMethod {

    // 创建锁
    Lock lock = new ReentrantLock();
    private Condition condition = lock.newCondition();

    private int hasValue = 0;

    public void set(){
        try {
            lock.lock();
            while (hasValue == 1) {
                System.out.println("  有可能★★★连续");
                condition.await();
            }
            System.out.println("打印★");
            hasValue = 1;
            condition.signalAll();
        }catch (Exception e){
            // doNothing
        }finally {
            lock.unlock();
        }
    }


    public void get(){
        try{
            lock.lock();
            while(hasValue == 0){
                System.out.println(" 有可能连续☆☆☆");
                condition.await();
            }
            System.out.println("打印☆");
            hasValue = 0;
            condition.signalAll();
        }catch (Exception e){
            // doNothing
        }finally {
            lock.unlock();
        }
    }
}
