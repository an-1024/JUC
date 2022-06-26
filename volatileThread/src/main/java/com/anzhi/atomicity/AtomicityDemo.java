package com.anzhi.atomicity;

import java.util.concurrent.atomic.AtomicInteger;

public class AtomicityDemo {
    public static volatile int race = 0;

    private static final int THREADS_COUNT = 20;

    private static AtomicInteger atomicInteger = new AtomicInteger(1);


    public static void increase(){
        atomicInteger.getAndIncrement();
        race++;
    }

    public static void main(String[] args) throws InterruptedException {
        Thread[] threads = new Thread[THREADS_COUNT];

        for(int i=0; i<THREADS_COUNT; i++){
            threads[i] = new Thread(new Runnable() {
                public void run() {
                    for (int i=0; i<1000; i++){
                        increase();
                    }
                }
            });
            threads[i].start();
        }

        // 等待所有累加线程都结束
        // idea 会自动创建一条名为 Monitor Ctrl-Break 的线程
        while (Thread.activeCount() > 2){
            Thread.yield();
        }


        System.out.println("race 的值为: " + race + " atomicInteger= " + atomicInteger.get());
    }
}
