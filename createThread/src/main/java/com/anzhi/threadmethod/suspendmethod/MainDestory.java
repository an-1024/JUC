package com.anzhi.threadmethod.suspendmethod;

public class MainDestory extends Thread{
    private long i=0;

    @Override
    public void run() {
        while(true){
            i++;
        }
    }
}
