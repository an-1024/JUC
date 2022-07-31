package com.anzhi.singletonpatternandmultithreading;

public class SingleEnumDemoThreadTest {
    public static void main(String[] args) {
        for (int i=0; i<100; i++){
            SingleEnumDemoThread singleEnumDemoThread = new SingleEnumDemoThread();
            Thread t1 = new Thread(singleEnumDemoThread);

            t1.start();
        }
    }
}
