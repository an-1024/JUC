package com.anzhi.singletonpatternandmultithreading;

public class LazyModSynchronizedDemo {

    private static LazyModSynchronizedDemo lazyModeDemo;

    public LazyModSynchronizedDemo() {
    }

    public static LazyModSynchronizedDemo getInstance(){
        if (lazyModeDemo != null){
        }else {
            // 模拟在创建对象之前做一些准备性的工作
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                // doNothing
            }
            synchronized(LazyModeDemo.class) {
                lazyModeDemo = new LazyModSynchronizedDemo();
            }
        }
        return lazyModeDemo;
    }
}
