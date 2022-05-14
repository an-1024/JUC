package com.anzhi.threadpriority.threadpirorityeffectiv;

public class ThreadExecuteEffectivA extends Thread{
    private long count = 0;

    public long getCount() {
        return count;
    }

    @Override
    public void run() {
        while(true){
            count++;
        }
    }
}
