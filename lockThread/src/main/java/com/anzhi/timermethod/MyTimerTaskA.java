package com.anzhi.timermethod;

import java.util.TimerTask;

public class MyTimerTaskA extends TimerTask {
    @Override
    public void run() {
        System.out.println("MyTimerTaskA run timer= " + System.currentTimeMillis());
        this.cancel();
        System.out.println("MyTimerTaskA 移除自己");
    }
}
