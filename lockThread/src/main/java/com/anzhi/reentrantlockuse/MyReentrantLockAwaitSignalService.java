package com.anzhi.reentrantlockuse;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class MyReentrantLockAwaitSignalService {
    private Lock lock = new ReentrantLock();
    
    public Condition condition = lock.newCondition();
    
    public void awaitMethod(){
        try{
            lock.lock();
            System.out.println("  await 时间为" + System.currentTimeMillis());
            condition.await();
        }catch (Exception e){
            // doNothing
        }finally {
            lock.unlock();
        }
    }
    
    
    public void signalMethod(){
        try{
            lock.lock();
            System.out.println(" signal 时间为" + System.currentTimeMillis());
            condition.signal();
        }catch (Exception e){
            
        }finally {
            lock.unlock();
        }
    }
}
