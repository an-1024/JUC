package com.anzhi.threadpriority.threadpriorityextends;

public class ThreadPriorityTest {
    public static void main(String[] args) {
        System.out.println("main thread begin priority= " + Thread.currentThread().getPriority());
        // Thread.currentThread().setPriority(6);
        System.out.println("main thread end priority= " + Thread.currentThread().getPriority());
        ThreadPriority th = new ThreadPriority();
        th.start();
    }
}
