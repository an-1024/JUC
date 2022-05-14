package com.anzhi.threadmethod.interrupmethod;

public class InterruptThreadMethodTest {
    public static void main(String[] args) {
        InterruptThreadMethod interruptThreadMethod = new InterruptThreadMethod();
        interruptThreadMethod.start();
        interruptThreadMethod.interrupt();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            // doNothing
        }

        Thread.currentThread().interrupt();
        System.out.println("是否停止1？ = " + Thread.currentThread().isInterrupted());
        System.out.println("是否停止2？ = " + Thread.currentThread().isInterrupted());
        System.out.println("InterruptThreadMethod test");
    }
}
