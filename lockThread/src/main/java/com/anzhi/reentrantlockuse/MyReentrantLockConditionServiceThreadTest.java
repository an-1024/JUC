package com.anzhi.reentrantlockuse;

public class MyReentrantLockConditionServiceThreadTest {
    public static void main(String[] args) {
        MyReentrantLockConditionService conditionService = new MyReentrantLockConditionService();
        
        for (int i=0; i<3; i++){
            Thread thread = new Thread(new MyReentrantLockConditionServiceThread(conditionService));
            thread.setName("t" + i);
            thread.start();
        }
    }
}
