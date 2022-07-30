package com.anzhi.timermethod;

import java.util.TimerTask;

public class MyTimer extends TimerTask {
    @Override
    public void run() {
        System.out.println("任务执行了, 时间为: " + System.currentTimeMillis());
    }
}
