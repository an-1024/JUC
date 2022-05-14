package com.anzhi.threadmethod.suspendmethod;

public class MainDestoryTest {
    public static void main(String[] args) {
        try{
            MainDestoryAnotherDeadLock th = new MainDestoryAnotherDeadLock();
            th.setName("th");
            th.start();
            Thread.sleep(1000);
            th.suspend();
            System.out.println("main end");
        }catch (InterruptedException e){
            // doNothing
        }
    }
}
