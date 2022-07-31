package com.anzhi.singletonpatternandmultithreading;

public class SingleEnumDemoThread implements Runnable{
    @Override
    public void run() {
        System.out.println(SingleEnumDemo.SingleEnum.SINGLETON.getINSTANCE().hashCode());
    }
}
