package com.anzhi.timermethod;

import java.util.Date;
import java.util.Timer;

public class MyTimerTest {
    public static void main(String[] args) {
        long nowTime = System.currentTimeMillis();
        System.out.println("当前时间为：" + nowTime);

        long scheduleTime = (nowTime + 10000);
        System.out.println("计划时间为: " + scheduleTime);

        MyTimer task = new MyTimer();

        Timer timer = new Timer();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            // doNothing
        }
        timer.schedule(task, new Date(scheduleTime));

        try {
            Thread.sleep(Integer.MAX_VALUE);
        } catch (InterruptedException e) {
            // doNothing
        }
    }
}