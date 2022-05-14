package com.anzhi.threadpriority.threadpriorityextends;

public class ThreadPriority2 extends Thread{
    @Override
    public void run() {
        System.out.println("ThreadPriority2 run priority= " + this.getPriority());
    }
}
