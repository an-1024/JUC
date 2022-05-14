package com.anzhi.threadmethod.currentthread;

public class CurrentThreadTest {
    public static void main(String[] args) {
        CurrentThreadMethod currentThreadMethod = new CurrentThreadMethod();
        Thread t = new Thread(currentThreadMethod);
        t.setName("执行线程A");
        t.start();
        t.run();
    }
}
