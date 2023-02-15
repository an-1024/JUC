package com.anzhi.jvmoptimization;

import java.util.concurrent.CountDownLatch;

public class DeadLock {
    private static CountDownLatch lock1 = new CountDownLatch(1);
    private static CountDownLatch lock2 = new CountDownLatch(1);

    public static void main(String[] args) {
        new Thread(()->{
            try {
                System.out.println("T1 线程开始执行");
                lock1.await();
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                // doNothing
            }
            lock2.countDown();
            System.out.println("T1 线程结束");
        }, "T1").start();

        new Thread(()->{
            try {
                System.out.println("T2 线程开始执行");
                lock2.await();
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                // doNothing
            }
            lock1.countDown();
            System.out.println("T2 线程结束");
        }, "T2").start();
    }
}
