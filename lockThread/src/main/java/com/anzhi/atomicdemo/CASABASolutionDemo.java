package com.anzhi.atomicdemo;

import java.util.concurrent.atomic.AtomicStampedReference;

/**
 * CAS ABA 问题解决
 */
public class CASABASolutionDemo {
    private static AtomicStampedReference<Integer> atomicStampedReference = new AtomicStampedReference<>(10, 1);
    public static void main(String[] args) {
        Thread threadA = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("线程A拿到当前初始时间戳版本号为：" + atomicStampedReference.getStamp());
                //比较并交换,将值从 10 设置为 11
                atomicStampedReference.compareAndSet(10, 11, atomicStampedReference.getStamp(), atomicStampedReference.getStamp() + 1);
                System.out.println("线程A拿到当前时间戳版本号为：" + atomicStampedReference.getStamp());
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
                System.out.println("线程B拿到当前初始时间戳版本号为：" + atomicStampedReference.getStamp());
                //比较并交换,将值从 11 设置为 10
                atomicStampedReference.compareAndSet(11, 10, atomicStampedReference.getStamp(), atomicStampedReference.getStamp() + 1);
                System.out.println("线程B拿到当前时间戳版本号为：" + atomicStampedReference.getStamp());
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
                System.out.println("线程C拿到当前初始时间戳版本号为：" + atomicStampedReference.getStamp());
                //比较并交换,将值从 10 设置为 11
                boolean result = atomicStampedReference.compareAndSet(10, 11, atomicStampedReference.getStamp(), atomicStampedReference.getStamp() + 1);
                System.out.println("线程C拿到当前时间戳版本号为：" + atomicStampedReference.getStamp() + " 修改结果为：" + result);
            }
        }, "C线程");

        //启动线程
        threadA.start();
        threadB.start();
        threadC.start();
    }
}
