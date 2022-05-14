package com.anzhi.threadmethod.returnstopthread.interruptstopthreadmethod;

public class InterruptStopThread extends Thread{
    @Override
    public void run() {
        try {
            // insert 操作
            if (Thread.interrupted()) {
                throw new InterruptedException();
            }
            // updates 操作
            if (Thread.interrupted()) {
                throw new InterruptedException();
            }
        }catch (InterruptedException e){
            System.out.println("写入 log info");
        }
    }
}
