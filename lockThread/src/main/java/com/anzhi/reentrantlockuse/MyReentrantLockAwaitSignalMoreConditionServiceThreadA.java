package com.anzhi.reentrantlockuse;

public class MyReentrantLockAwaitSignalMoreConditionServiceThreadA implements Runnable{
    
    private MyReentrantLockAwaitSignalMoreConditionService awaitSignalMoreConditionService = new MyReentrantLockAwaitSignalMoreConditionService();

    public MyReentrantLockAwaitSignalMoreConditionServiceThreadA(MyReentrantLockAwaitSignalMoreConditionService awaitSignalMoreConditionService) {
        this.awaitSignalMoreConditionService = awaitSignalMoreConditionService;
    }

    @Override
    public void run() {
        awaitSignalMoreConditionService.awaitMethodA();
    }
}
