package com.anzhi.atomicdemo;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * CAS 带来的 ABA 问题
 */
public class CASABADemo {
    private static AtomicInteger at = new AtomicInteger(1);
    public static void main(String[] args) throws InterruptedException {
        Thread threadA = new Thread(new Runnable() {
            @Override
            public void run() {
                int i = at.get();
                System.out.println("线程A读取初始值：" + i);//1
                //比较并交换,将at的值从1修改为2
                at.compareAndSet(at.get(), 2);
            }
        }, "A线程");

        Thread threadB = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    //线程B调用线程A的join方法，线程B会阻塞直到线程A执行完毕。
                    threadA.join();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                int i = at.get();
                System.out.println("线程B读取初始值：" + i);//1
                //比较并交换，将at的值由2修改回1
                at.compareAndSet(i, 1);
            }
        }, "B线程");

        Thread threadC = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    //线程B调用线程B的join方法，线程B会阻塞直到线程B执行完毕。
                    threadB.join();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                int i = at.get();
                System.out.println("线程C读取初始值：" + i);//1
                //比较并交换，将at的值由1修改回2
                boolean result = at.compareAndSet(i, 2);
                System.out.println("线程C比较并修改at的值的执行结果-> "+result);
            }
        }, "C线程");

        //启动线程
        threadA.start();
        threadB.start();
        threadC.start();
    }
}
