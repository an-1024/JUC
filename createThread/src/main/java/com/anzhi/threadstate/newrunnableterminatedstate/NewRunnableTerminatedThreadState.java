package com.anzhi.threadstate.newrunnableterminatedstate;

public class NewRunnableTerminatedThreadState extends Thread{
    public NewRunnableTerminatedThreadState(){
        System.out.println("Thread.currentThread().getState()= " + Thread.currentThread().getState());
        System.out.println("this.getState()= " + this.getState());
    }

    @Override
    public void run() {
        System.out.println("NewRunnableTerminatedThreadState run state= " + Thread.currentThread().getState());
    }
}
