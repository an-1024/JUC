package com.anzhi.threadmethod.returnstopthread.returnstopthreadmethod;

import com.anzhi.threadmethod.returnstopthread.returnstopthreadmethod.ReturnStopThreadWithInterrupt;

public class ReturnStopThreadWithInterruptTest {
    public static void main(String[] args) {
        ReturnStopThreadWithInterrupt t = new ReturnStopThreadWithInterrupt();
        t.start();
        try {
            Thread.sleep(1);
        } catch (InterruptedException e) {
            //
        }
        t.interrupt();
    }
}
