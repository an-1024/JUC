package com.anzhi.reentrantlockuse;

public class MyReentrantLockConditionServiceThread implements Runnable{
    
    private MyReentrantLockConditionService conditionService;

    public MyReentrantLockConditionServiceThread(MyReentrantLockConditionService conditionService) {
        this.conditionService = conditionService;
    }

    @Override
    public void run() {
        conditionService.waitCondition();
    }
}
