package com.anzhi.threadstate.newrunnableterminatedstate;

public class TimedWaitingThreadTest {
    public static void main(String[] args) {
        try {
            TimedWaitingThread thread = new TimedWaitingThread();
            thread.start();
            Thread.sleep(1000);
            System.out.println("main 方法中 thread 线程状态: " + thread.getState());
        }catch (InterruptedException e){
            // doNothing
        }
    }
}
