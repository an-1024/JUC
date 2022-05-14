package com.anzhi.threadmethod.currentthread;

public class CurrentThreadMethod extends Thread{

    public CurrentThreadMethod(){
        System.out.println("构造方法的打印，当前线程执行名称：: " + Thread.currentThread().getName());
        System.out.println("构造方法的打印，当前类的名称：" + this.getName());
    }

    @Override
    public void run() {
        System.out.println("run 方法打印, 当前线程执行名称：" + Thread.currentThread().getName());
        System.out.println("run 方法打印，当前类的名称" + this.getName());
    }
}
