package com.anzhi.threadmethod.interrupmethod;

public class SleepInterruptedMethod extends Thread{
    @Override
    public void run() {
        try{
            System.out.println("run begin");
            Thread.sleep(2000);
            System.out.println("run end");
        }catch (InterruptedException e){
            System.out.println("在沉睡中被停止：进入 catch!" + this.isInterrupted());
            e.printStackTrace();
        }
    }
}
