package com.anzhi.singletonpatternandmultithreading;

public class HungryManModeDemoThreadTest {
    public static void main(String[] args) {
        HungryManModeDemoThread hungryManModeDemo1 = new HungryManModeDemoThread();
        Thread t1 = new Thread(hungryManModeDemo1);

        HungryManModeDemoThread hungryManModeDemo2 = new HungryManModeDemoThread();
        Thread t2 = new Thread(hungryManModeDemo2);

        HungryManModeDemoThread hungryManModeDemo3 = new HungryManModeDemoThread();
        Thread t3 = new Thread(hungryManModeDemo3);

        t1.start();
        t2.start();
        t3.start();
    }
}
