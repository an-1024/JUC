package com.anzhi.threadmethod.stopthread;

public class StopThreadMethod extends Thread{
    int i=0;
    @Override
    public void run() {
        try{
            while (true){
                i++;
                System.out.println("i = " + i);
                Thread.sleep(1000);
            }
        }catch (InterruptedException e){
            // doNothing
        }
    }
}
