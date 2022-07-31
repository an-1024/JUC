package com.anzhi.singletonpatternandmultithreading;

public class StaticInnerClassDemo {
    private static class StaticInnerClass{
        private static StaticInnerClassDemo innerClassDemo = new StaticInnerClassDemo();
    }

    private StaticInnerClassDemo (){}

    public static StaticInnerClassDemo getInstance(){
        return StaticInnerClass.innerClassDemo;
    }
}
