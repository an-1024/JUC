package com.anzhi.threadpriority.threadpriorityexecute;

import java.util.Random;

public class ThreadPriorityExecute2 extends Thread{
    @Override
    public void run() {
        long beginTime = System.currentTimeMillis();
        long addResult = 0;
        for(int j=0; j<10; j++){
            for(int i=0; i<50000; i++){
                Random random = new Random();
                addResult = random.nextInt() + i;
            }
        }
        long endTime = System.currentTimeMillis();
        System.out.println("☆☆☆ThreadPriorityExecute2 use time= " + (endTime - beginTime));
    }
}
