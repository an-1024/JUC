package com.anzhi.timermethod;

import java.util.TimerTask;

public class MyTimerTaskB extends TimerTask {
    @Override
    public void run() {
        System.out.println("MyTimerTaskB run timer= " + System.currentTimeMillis());
    }
}
