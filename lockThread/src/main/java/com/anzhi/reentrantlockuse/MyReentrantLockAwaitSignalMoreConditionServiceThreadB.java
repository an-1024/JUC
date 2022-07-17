package com.anzhi.reentrantlockuse;

public class MyReentrantLockAwaitSignalMoreConditionServiceThreadB implements Runnable{
    private MyReentrantLockAwaitSignalMoreConditionService awaitSignalMoreConditionService = new MyReentrantLockAwaitSignalMoreConditionService();

    public MyReentrantLockAwaitSignalMoreConditionServiceThreadB(MyReentrantLockAwaitSignalMoreConditionService awaitSignalMoreConditionService) {
        this.awaitSignalMoreConditionService = awaitSignalMoreConditionService;
    }

    @Override
    public void run() {
        awaitSignalMoreConditionService.awaitMethodB();
    }
    
}
