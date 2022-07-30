package com.anzhi.timermethod;

import java.util.Date;
import java.util.Timer;

public class MyTimerCancelTest {
    public static void main(String[] args) {
        long nowTime = System.currentTimeMillis();
        System.out.println("当前时间为：" + nowTime);

        long scheduleTime = (nowTime + 15000);
        System.out.println("计划时间为: " + scheduleTime);

        MyTimer task = new MyTimer();

        Timer timer = new Timer();
        timer.schedule(task, new Date(scheduleTime));

        try {
            Thread.sleep(18000);
            timer.cancel();
        } catch (InterruptedException e) {
            // doNothing
        }
    }
}
