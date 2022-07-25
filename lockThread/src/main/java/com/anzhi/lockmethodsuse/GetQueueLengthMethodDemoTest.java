package com.anzhi.lockmethodsuse;

import java.util.concurrent.locks.ReentrantLock;

public class GetQueueLengthMethodDemoTest {
    public static void main(String[] args) {
        GetQueueLengthMethodDemo queueLengthMethodDemo = new GetQueueLengthMethodDemo();

        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                queueLengthMethodDemo.queueLengthMethodDemo();
            }
        };

        Thread[] threadArray = new Thread[10];
        for (int i=0; i<10; i++){
            threadArray[i] = new Thread(runnable);
        }

        for(int i=0; i<10; i++){
            threadArray[i].start();
        }

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            // doNothing
        }

        System.out.println("有线程数： " + queueLengthMethodDemo.getLock().getQueueLength() + "在等待获取锁");
    }
}
