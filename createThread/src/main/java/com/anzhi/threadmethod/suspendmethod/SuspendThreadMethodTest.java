package com.anzhi.threadmethod.suspendmethod;

public class SuspendThreadMethodTest {
    public static void main(String[] args) {
        try {
            SuspendThreadMethod th = new SuspendThreadMethod();
            th.setName("A");
            th.start();
            //Thread.sleep(5000);

            // A 暂停
            th.suspend();

            System.out.println("A= " + System.currentTimeMillis() + " i= " + th.getI());
            Thread.sleep(5000);
            System.out.println("A= " + System.currentTimeMillis() + " i= " + th.getI());
            System.out.println("th 线程状态= " + th.getState());

            // B 段
            th.resume();
            Thread.sleep(5000);

            // C 段
            th.suspend();
            System.out.println("B= " + System.currentTimeMillis() + " i= " + th.getI());
            Thread.sleep(5000);
            System.out.println("B= " + System.currentTimeMillis() + " i= " + th.getI());
        }catch (InterruptedException e){

        }
    }
}
