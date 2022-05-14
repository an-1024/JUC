package com.anzhi.threadcreate;

public class CreateThreadBByRunnable extends CreateThreadAByRunnable implements Runnable{

    public void bThreadSaveMethod(){
        System.out.println("b_Thread 中的保存方法被执行");
    }

    @Override
    public void run() {
        bThreadSaveMethod();
    }
}
