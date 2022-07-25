package com.anzhi.reentrantlockconsumerproducer;

public class MyReentrantLockConditionConsumerThread implements Runnable{

    private MyReentrantLockConditionMethod conditionMethod;

    public MyReentrantLockConditionConsumerThread(MyReentrantLockConditionMethod conditionMethod) {
        this.conditionMethod = conditionMethod;
    }

    @Override
    public void run() {
        for(int i=0; i<Integer.MAX_VALUE; i++){
            conditionMethod.get();
        }
    }
}
