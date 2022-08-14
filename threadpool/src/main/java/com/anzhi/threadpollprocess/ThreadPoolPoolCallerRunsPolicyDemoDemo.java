package com.anzhi.threadpollprocess;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ThreadPoolPoolCallerRunsPolicyDemoDemo {

    private static boolean flag = true;

    public static void main(String[] args) {
        Thread.currentThread().setName("MainThread");
        int cps = Runtime.getRuntime().availableProcessors();
        int mps = Runtime.getRuntime().availableProcessors() * 2 - 1;
        int c= 5;
        int size = mps + 5;
        ThreadPoolExecutor abortPolicyThread = new ThreadPoolExecutor(cps, mps,
                600L, TimeUnit.SECONDS,
                new LinkedBlockingQueue<>(c),
                new NamedThreadFactory("threadPoolDemo"),
                new ThreadPoolExecutor.DiscardOldestPolicy());

        for(int i=0; i<size; i++){
            abortPolicyThread.execute(()->{
                try {
                    System.out.println("--------------------" + Thread.currentThread().getName());
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    // doNothing
                }
            });
        }

        // 测试 CallerRunsPolicy: 那个任务拒绝那个线程负责执行：类似于产品向开发提要求，开发没有资源，产品自己上手


        ThreadPoolExecutor tpe = ((ThreadPoolExecutor) abortPolicyThread);
        System.out.println("current queue wait count = " + tpe.getQueue().size());
        System.out.println("current active Thread count = " + tpe.getActiveCount());
        System.out.println("current completed Thread count = " + tpe.getCompletedTaskCount());
        System.out.println("current task Thread count = " + tpe.getTaskCount());

        abortPolicyThread.execute(()->{
            flag = false;
            System.out.println(Thread.currentThread().getName() + " start add task");
        });

        System.out.println(Thread.currentThread().getName() + "---------- wait" );

        // 每隔 10 秒查看一下线程池参数
        while(flag){
            System.out.println("current queue wait count = " + tpe.getQueue().size());
            System.out.println("current active Thread count = " + tpe.getActiveCount());
            System.out.println("current completed Thread count = " + tpe.getCompletedTaskCount());
            System.out.println("current task Thread count = " + tpe.getTaskCount());

            try {
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                // doNothing
            }
        }

    }
}
