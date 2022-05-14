package com.anzhi.threadmethod.sleepthread;

public class SleepThreadMethod extends Thread{
    @Override
    public void run() {
        System.out.println("run threadName = " + this.currentThread().getName() + "begin");
        try {
            this.sleep(2000);
            System.out.println("run threadName = "+ currentThread().getName() + "end");
        } catch (InterruptedException e) {
            // doNothing
        }
    }
}
