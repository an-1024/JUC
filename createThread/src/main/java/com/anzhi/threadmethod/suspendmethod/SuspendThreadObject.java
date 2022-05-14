package com.anzhi.threadmethod.suspendmethod;

public class SuspendThreadObject {
    synchronized public void printString(){
        System.out.println("begin");
        if(Thread.currentThread().getName().equals("a")){
            System.out.println("a 线程永远 suspend!");
            Thread.currentThread().suspend();
        }
        System.out.println("end");
    }
}
