package com.anzhi.threadpollprocess;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ThreadPoolDemo {
    public static void main(String[] args) {
        Thread.currentThread().setName("MainThread");
        int cps = Runtime.getRuntime().availableProcessors();
        int mps = Runtime.getRuntime().availableProcessors() * 2 - 1;
        int c= 5;
        int size = mps + 5;
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(cps, mps,
                600L, TimeUnit.SECONDS,
                new LinkedBlockingQueue<>(c),
                new NamedThreadFactory("threadPoolDemo"),
                new ThreadPoolExecutor.AbortPolicy());

        // 测试直接决绝策略
        for(int i=0; i<size; i++){
            threadPoolExecutor.execute(()->{
                try {
                    System.out.println("--------------------" + Thread.currentThread().getName());
                    Thread.sleep(1000000);
                } catch (InterruptedException e) {
                    // doNothing
                }
            });
        }

        ThreadPoolExecutor tpe = ((ThreadPoolExecutor) threadPoolExecutor);
        System.out.println("current queue wait count = " + tpe.getQueue().size());
        System.out.println("current active Thread count = " + tpe.getActiveCount());
        System.out.println("current completed Thread count = " + tpe.getCompletedTaskCount());
        System.out.println("current task Thread count = " + tpe.getTaskCount());

        threadPoolExecutor.execute(()->{
            System.out.println("add task");
        });

        System.out.println(Thread.currentThread().getName() + "---------- wait" );

        while(true){
            System.out.println("current queue wait count = " + tpe.getQueue().size());
            System.out.println("current active Thread count = " + tpe.getActiveCount());
            System.out.println("current completed Thread count = " + tpe.getCompletedTaskCount());
            System.out.println("current task Thread count = " + tpe.getTaskCount());
        }

    }
}
