package com.anzhi.reentrantlockuse;

public class MyReentrantLockAwaitSignalMoreConditionServiceThreadTest {
    public static void main(String[] args) {
        MyReentrantLockAwaitSignalMoreConditionService awaitSignalMoreConditionService = new MyReentrantLockAwaitSignalMoreConditionService();
        
        MyReentrantLockAwaitSignalMoreConditionServiceThreadA serviceThreadA = new MyReentrantLockAwaitSignalMoreConditionServiceThreadA(awaitSignalMoreConditionService);
        MyReentrantLockAwaitSignalMoreConditionServiceThreadB serviceThreadB = new MyReentrantLockAwaitSignalMoreConditionServiceThreadB(awaitSignalMoreConditionService);
        
        Thread threadA = new Thread(serviceThreadA);
        threadA.setName("threadA");
        
        Thread threadB = new Thread(serviceThreadB);
        threadB.setName("threadB");
        
        threadA.start();
        threadB.start();

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            // doNothing
        }
        
        awaitSignalMoreConditionService.signalAll_A();
    }
}
