package com.anzhi.singletonpatternandmultithreading;

public class DCLDemo {
    private static volatile DCLDemo dclDemo;

    public static DCLDemo getInstance(){
        if(dclDemo != null){
        }else{
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                // doNothing
            }
            synchronized (DCLDemo.class){
                if (dclDemo == null){
                    dclDemo = new DCLDemo();
                }
            }
        }
        return dclDemo;
    }
}
