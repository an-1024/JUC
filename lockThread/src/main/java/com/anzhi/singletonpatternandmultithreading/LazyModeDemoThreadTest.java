package com.anzhi.singletonpatternandmultithreading;

public class LazyModeDemoThreadTest {
    public static void main(String[] args) {
        LazyModeDemoThread lazyModeDemo1 = new LazyModeDemoThread();
        Thread t1 = new Thread(lazyModeDemo1);

        LazyModeDemoThread lazyModeDemo2= new LazyModeDemoThread();
        Thread t2 = new Thread(lazyModeDemo2);

        t1.start();
        t2.start();
    }
}
