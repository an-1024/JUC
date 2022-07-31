package com.anzhi.singletonpatternandmultithreading;

public class StaticInnerClassDemoThreadTest {
    public static void main(String[] args) {
        for (int i=0; i<100; i++){
            StaticInnerClassDemoThread innerClassDemoThread = new StaticInnerClassDemoThread();
            Thread t1 = new Thread(innerClassDemoThread);
            t1.start();
        }
    }
}
