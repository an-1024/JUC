package com.anzhi.threadpriority.threadpriorityexecute;

import java.util.Random;

public class ThreadPriorityExecuteTest extends Thread{
    public static void main(String[] args) {
        for(int i=0; i<5; i++){
            ThreadPriorityExecute execute = new ThreadPriorityExecute();
            execute.setPriority(6);
            execute.start();

            ThreadPriorityExecute2 execute2 = new ThreadPriorityExecute2();
            execute2.setPriority(5);
            execute2.start();
        }
    }
}
