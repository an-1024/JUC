package com.anzhi.threadmethod.sleepthread;

public class SleepThreadMethodTest {
    public static void main(String[] args) {

        // sleep(long millis, int nanos)
        long start3 = System.currentTimeMillis();
        System.out.println("begin----------------" + start3);
        try {
            Thread.sleep(2000, 999999);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("end------------------" + System.currentTimeMillis() + "花费时间为=" +(System.currentTimeMillis() - start3) + "ms");
    }
}
