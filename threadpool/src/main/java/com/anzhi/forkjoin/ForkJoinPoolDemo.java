package com.anzhi.forkjoin;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.TimeUnit;

public class ForkJoinPoolDemo {

    volatile long ctl;                   // main pool control
    volatile static int runState=0;               // lockable status
    private static final int  RSLOCK     = 1;


    public static void main(String[] args) {
        ForkJoinPool forkJoinPool = new ForkJoinPool();
        forkJoinPool.submit(()-> System.out.println("ForkJoinPool Demo"));
        forkJoinPool.shutdown();
        try {
            forkJoinPool.awaitTermination(1, TimeUnit.DAYS);
        } catch (InterruptedException e) {
            // doNothing
        }
    }
}
