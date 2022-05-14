package com.anzhi.threadmethod.stopthread;

public class StopThreadMethod2 extends Thread{
    int i=0;
    @Override
    public void run() {
        try{
            this.stop();
        }catch (ThreadDeath e){
            // doNothing
//            System.out.println("捕获 ThreadDeath 异常");
            int i=1;
        }
    }
}
