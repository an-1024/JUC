package com.anzhi.visibility;

public class VolatileVisibilityDemoTest {
    public static void main(String[] args) {
        VolatileVisibilityDemo volatileVisibilityDemo = new VolatileVisibilityDemo();
        Thread thread = new Thread(volatileVisibilityDemo);

        thread.start();

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            // doNothing
        }
        System.out.println("stop volatileVisibilityDemo method");
        volatileVisibilityDemo.setContinuePrintPrint(false);
    }
}
