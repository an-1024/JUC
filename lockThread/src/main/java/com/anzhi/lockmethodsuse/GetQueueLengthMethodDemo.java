package com.anzhi.lockmethodsuse;

import java.util.concurrent.locks.ReentrantLock;

public class GetQueueLengthMethodDemo {
    private ReentrantLock lock = new ReentrantLock(true);

    public void queueLengthMethodDemo(){
        try{
            lock.lock();
            System.out.println("ThreadName= " + Thread.currentThread().getName() + "进入方法");
            Thread.sleep(Integer.MAX_VALUE);
        }catch (Exception e){
            // doNothing
        }finally {
            lock.unlock();
        }
    }

    public ReentrantLock getLock() {
        return lock;
    }
}
