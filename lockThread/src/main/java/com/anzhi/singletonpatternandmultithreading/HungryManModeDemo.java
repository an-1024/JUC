package com.anzhi.singletonpatternandmultithreading;

public class HungryManModeDemo {
    private static HungryManModeDemo singleObject = new HungryManModeDemo();

    public HungryManModeDemo() {
    }

    public static HungryManModeDemo getInstance(){
        return singleObject;
    }
}
