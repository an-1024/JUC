package com.anzhi.cpucacheline;

public class CpuCacheLineDemo2 {
    private final long CYCLE_TIMES = 10_0000_0000L;
    private volatile long[] array = new long[16];
    public void test() throws InterruptedException {
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (long i = 0; i < CYCLE_TIMES; i++) {
                    array[0] = i;
                }
            }
        });
        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (long i = 0; i < CYCLE_TIMES; i++) {
                    array[8] = i;
                }
            }
        });
        long start = System.nanoTime();
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        long end = System.nanoTime();
        System.out.println("Duration: " + (end - start) / 100_0000);
    }

    public static void main(String[] args) throws Exception{
        CpuCacheLineDemo1 cpuCacheLineDemo1 = new CpuCacheLineDemo1();
        System.out.println("------------------------修改long数组大小为16, 并发修改数组中第 0、8 个元素-----------------------");
        cpuCacheLineDemo1.test();
    }
}
