package com.anzhi.threadmethod.returnstopthread.interruptstopthreadmethod;

public class ReturnStopThread extends Thread{
    @Override
    public void run() {
        // insert 操作
        if(Thread.interrupted()){
            System.out.println("写入 log info");
            return ;
        }
        // updates 操作
        if(Thread.interrupted()){
            System.out.println("写入 log info");
        }
    }
}
