package com.anzhi.cpucacheline;

public class FillManuallyCacheLineAnnotation {
    private static final long CYCLE_TIMES = 10_0000_0000L;
    private static class Inner {
        @sun.misc.Contended
        volatile long contendedField = 0L;
    }
    private static Inner[] array = new Inner[2];
    static {
        array[0] = new Inner();
        array[1] = new Inner();
    }
    public static void main(String[] args)throws InterruptedException {
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (long i = 0; i < CYCLE_TIMES; i++) {
                    array[0].contendedField = i;
                }
            }
        });
        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (long i = 0; i < CYCLE_TIMES; i++) {
                    array[1].contendedField = i;
                }
            }
        });
        System.out.println("------------------------ 自动填充 Cacheline 保证字节对齐-----------------------");
        long start = System.nanoTime();
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        long end = System.nanoTime();
        System.out.println("Duration: " + (end - start) / 100_0000);
    }
}
