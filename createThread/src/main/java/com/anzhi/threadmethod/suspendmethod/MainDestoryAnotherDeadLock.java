package com.anzhi.threadmethod.suspendmethod;

public class MainDestoryAnotherDeadLock extends Thread{
    private long i=0;

    @Override
    public void run() {
        while(true){
            i++;
            System.out.println(i);
        }
    }
}
