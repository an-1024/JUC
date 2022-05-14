package com.anzhi.threadmethod.suspendmethod;

public class SuspendDataMissTest {
    public static void main(String[] args) throws InterruptedException {
        final SuspendDataMiss th = new SuspendDataMiss();

        Thread thread = new Thread(){
            @Override
            public void run() {
                th.setValue("a", "aa");
            }
        };

        thread.setName("a");
        thread.start();

        Thread.sleep(500);

        Thread thread2 = new Thread(){
            @Override
            public void run() {
                th.printUserNamePPassword();
            }
        };
        thread2.start();
    }
}
