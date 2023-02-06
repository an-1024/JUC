package com.anzhi.jvmmemorystructure;

public class TestExample {
    public static final int initData = 666;

    public int compute(){
        int a = 1;
        int b = 2;

        int c = (a+b)*10;

        return c;
    }

    public static void main(String[] args) {
        TestExample testExample = new TestExample();
        int count = testExample.compute();
        System.out.println("test=" + count);
    }
}
