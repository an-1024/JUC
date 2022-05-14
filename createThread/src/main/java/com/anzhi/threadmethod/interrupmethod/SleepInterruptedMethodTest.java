package com.anzhi.threadmethod.interrupmethod;

public class SleepInterruptedMethodTest {
    public static void main(String[] args) {
        SleepInterruptedMethod sleepThread = new SleepInterruptedMethod();
        sleepThread.start();
        //Thread.sleep(200);
        sleepThread.interrupt();
        System.out.println("end");
    }
}
