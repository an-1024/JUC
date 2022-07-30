package com.anzhi.singletonpatternandmultithreading;

public class LazyModeDemoThread implements Runnable{
    @Override
    public void run() {
        System.out.println(LazyModeDemo.getInstance().hashCode());
    }
}
