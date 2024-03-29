package com.anzhi.fairornofairlock;

public class LockRunFairDemoTest {
    public static void main(String[] args) {
        final LockFairMethod lockFairMethod = new LockFairMethod(true);
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                System.out.println("★线程 " + Thread.currentThread().getName() + "运行了 ");
                lockFairMethod.lockMethodService();
            }
        };

        Thread[] threadArray = new Thread[10];
        for (int i=0; i<10; i++){
            threadArray[i] = new Thread(runnable);
        }

        for(int i=0; i<10; i++){
            threadArray[i].start();
        }
    }
}
