package com.anzhi.threadpriority.threadpriorityextends;

public class ThreadPriority extends Thread{
    @Override
    public void run() {
        System.out.println("threadPriority run priority= " + this.getPriority());
        ThreadPriority2 threadPriority = new ThreadPriority2();
        threadPriority.start();
    }
}
