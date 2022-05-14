package com.anzhi.threadstate.newrunnableterminatedstate;

public class NewRunnableTerminatedThreadStateTest {
    public static void main(String[] args) {
        try {
            NewRunnableTerminatedThreadState thread = new NewRunnableTerminatedThreadState();
            System.out.println("main 方法中的状态1= " + thread.getState());
            Thread.sleep(1000);
            thread.start();
            Thread.sleep(1000);
            System.out.println("main 方法中的状态2= " + thread.getState());
        }catch (InterruptedException e){
            // doNothing
        }
    }
}
