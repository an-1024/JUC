package com.anzhi.singletonpatternandmultithreading;

import java.util.Random;

public class DCLReorderingDemo {
    public int i_am_has_state = 0;

    private static DCLReorderingDemo dclReorderingDemo;

    private DCLReorderingDemo () {
        i_am_has_state = new Random().nextInt(200) + 1;
    }

    public static DCLReorderingDemo getInstance() {
        if (dclReorderingDemo == null) {
            synchronized (DCLReorderingDemo.class){
                if (dclReorderingDemo == null){
                    dclReorderingDemo = new DCLReorderingDemo();
                }
            }
        }
        return dclReorderingDemo;
    }

    public static void reset() {
        dclReorderingDemo = null;
    }
}
