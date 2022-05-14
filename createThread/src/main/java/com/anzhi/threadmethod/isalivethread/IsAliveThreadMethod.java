package com.anzhi.threadmethod.isalivethread;

public class IsAliveThreadMethod extends Thread{

    public IsAliveThreadMethod() {
        System.out.println("ThreadisAliveMethod-------------begin");
        System.out.println("Thread.currentThread.getName=" + Thread.currentThread().getName());
        System.out.println("currentThread.isAlive=" + Thread.currentThread().isAlive());
        System.out.println("this.getName()=" + this.getName());
        System.out.println("this.isAlive=" + this.isAlive());
        System.out.println("ThreadisAliveMethod-------------end");

    }

    @Override
    public void run() {
        System.out.println("run-------------begin");
        System.out.println("Thread.currentThread.getName=" + Thread.currentThread().getName());
        System.out.println("currentThread.isAlive=" + Thread.currentThread().isAlive());
        System.out.println("thi.getName()=" + this.getName());
        System.out.println("this.isAlive=" + this.isAlive());
        System.out.println("run-------------end");
    }
}
