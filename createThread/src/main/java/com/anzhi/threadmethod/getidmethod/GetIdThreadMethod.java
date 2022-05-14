package com.anzhi.threadmethod.getidmethod;

public class GetIdThreadMethod extends Thread{
    @Override
    public void run() {
        System.out.println("----------------------begin");
        this.interrupted();
        System.out.println("runThreadName.getNamew=" + Thread.currentThread().getName() + "  runThreadId= "
                + Thread.currentThread().getId() + "  runThreadState= " + Thread.currentThread().getState());
    }
}
