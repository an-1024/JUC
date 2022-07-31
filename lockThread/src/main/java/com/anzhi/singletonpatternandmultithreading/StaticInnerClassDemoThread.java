package com.anzhi.singletonpatternandmultithreading;

public class StaticInnerClassDemoThread implements Runnable{

    @Override
    public void run() {
        System.out.println(StaticInnerClassDemo.getInstance().hashCode());
    }
}
