package com.anzhi.threadmethod.isalivethread;

public class IsAliveThreadTest {
    public static void main(String[] args) {
        // 直接使用 start 启动线程
        IsAliveThreadMethod threadisAliveMethod = new IsAliveThreadMethod();
        System.out.println("threadisAliveMethod 线程状态 start ：" + threadisAliveMethod.isAlive());
        threadisAliveMethod.start();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            //doNothing
        }
        System.out.println("threadisAliveMethod 线程状态 end：" + threadisAliveMethod.isAlive());

        // 将线程作为构造参数传入 Thread
        IsAliveThreadMethod aliveMethod = new IsAliveThreadMethod();
        Thread t2 = new Thread(aliveMethod);
        System.out.println("t2 线程状态 start ：" + t2.isAlive());
        t2.setName("aliveThread");
        t2.start();
        System.out.println("t2 线程状态 end：" + t2.isAlive());
    }
}
