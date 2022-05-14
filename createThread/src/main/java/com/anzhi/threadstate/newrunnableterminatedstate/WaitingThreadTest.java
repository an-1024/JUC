package com.anzhi.threadstate.newrunnableterminatedstate;

public class WaitingThreadTest extends Thread{
    public static void main(String[] args) {
        try {
            WaitingThread thread = new WaitingThread();
            thread.start();
            Thread.sleep(100);
            System.out.println("main 方法中 thread 的状态：" + thread.getState());
        }catch (InterruptedException e){
            // doNothing
        }
    }
}
