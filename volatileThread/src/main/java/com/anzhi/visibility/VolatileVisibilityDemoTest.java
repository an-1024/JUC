package com.anzhi.visibility;

public class VolatileVisibilityDemoTest {
    public static void main(String[] args) {
        VolatileVisibilityDemo volatileVisibilityDemo = new VolatileVisibilityDemo();
        volatileVisibilityDemo.printStringMethodMethod();
        System.out.println("stop volatileVisibilityDemo method");
        volatileVisibilityDemo.isContinuePrintPrint(false);
    }
}
