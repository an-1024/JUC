package com.anzhi.threadcreate;

public class ThreadTest {
    public static void main(String[] args) {
        CreateThreadByExtendsThread t = new CreateThreadByExtendsThread();
        t.setName("CreateThreadByExtendsThread"); // 指定线程执行名称
        t.start();  // 耗时较长
        System.out.println("当前线程" + Thread.currentThread().getName() + "执行结束， 归属线程组为：" + Thread.currentThread().getThreadGroup() + "\n"
                + "当前线程" + t.getName() + "执行结束, 归属线程组为: " + t.getThreadGroup()); //主线程耗时较短

        CreateThreadByRunnable runnable = new CreateThreadByRunnable();
        Thread t2 = new Thread(runnable);
        t2.setName("CreateThreadByRunnable");
        t2.start();  // 耗时较长
        System.out.println("当前线程" + Thread.currentThread().getName() + "执行结束， 归属线程组为：" + Thread.currentThread().getThreadGroup() + "\n"
                + "当前线程" + t2.getName() + "执行结束, 归属线程组为: " + t2.getThreadGroup()); //主线程耗时较短

        Thread t3 = new Thread(t);
        t3.setName("测试Thread可以传入Runnable接口");
        t3.start();

    }
}
