package com.anzhi.singletonpatternandmultithreading;

public class HungryManModeDemoThread implements Runnable{
    @Override
    public void run() {
        System.out.println(HungryManModeDemo.getInstance().hashCode());
    }
}
