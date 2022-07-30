package com.anzhi.timermethod;

import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

public class MyTimerTaskCancelTest {
    public static void main(String[] args) {
        long nowTime = System.currentTimeMillis();
        System.out.println("当前时间为: " + nowTime);

        System.out.println("计划时间为: " + nowTime);

        MyTimerTaskA task1 = new MyTimerTaskA();
        MyTimerTaskB task2 = new MyTimerTaskB();

        Timer timer = new Timer();

        timer.schedule(task1, new Date(nowTime), 4000);
        timer.schedule(task2, new Date(nowTime), 4000);

        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            // doNothing
        }

        timer.cancel();
    }
}
