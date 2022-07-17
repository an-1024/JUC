package com.anzhi.reentrantlockuse;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class MyReentrantLockConditionService {
    
    private Lock lock = new ReentrantLock();
    
    private Condition condition = lock.newCondition();
    
    
    public void waitCondition(){
        try {
            lock.lock();
            System.out.println("上锁等待解锁");
            System.out.println(" 执行 await 方法, 使线程" + Thread.currentThread().getName() +"进入 wait 状态");
            condition.await();
            System.out.println();
        } catch (InterruptedException e) {
            // doNothing
        }finally {
            lock.unlock();
            System.out.println("锁释放了");
        }
    }
    
}
