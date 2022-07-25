package com.anzhi.reentrantlockconsumerproducer;

public class MyReentrantLockConditionProducerThread implements Runnable{

    private MyReentrantLockConditionMethod conditionMethod;

    public MyReentrantLockConditionProducerThread(MyReentrantLockConditionMethod conditionMethod) {
        this.conditionMethod = conditionMethod;
    }

    @Override
    public void run() {
        for(int i=0; i<Integer.MAX_VALUE; i++){
            conditionMethod.set();
        }
    }
}
