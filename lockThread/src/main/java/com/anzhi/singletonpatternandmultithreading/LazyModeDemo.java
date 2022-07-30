package com.anzhi.singletonpatternandmultithreading;

public class LazyModeDemo {

    private static LazyModeDemo lazyModeDemo;

    public LazyModeDemo() {
    }

    public static LazyModeDemo getInstance(){
        if (lazyModeDemo != null){
        }else {
            lazyModeDemo = new LazyModeDemo();
        }
        return lazyModeDemo;
    }
}
