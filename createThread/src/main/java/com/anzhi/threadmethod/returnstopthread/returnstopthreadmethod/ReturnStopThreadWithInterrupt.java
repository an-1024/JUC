package com.anzhi.threadmethod.returnstopthread.returnstopthreadmethod;

public class ReturnStopThreadWithInterrupt extends Thread{
    @Override
    public void run() {
        while(true){
            if(Thread.interrupted()){
                System.out.println("ReturnStopThreadWithInterrupt 线程停止了");
                return ;
            }
            System.out.println("timer= " + System.currentTimeMillis());
        }
    }
}
