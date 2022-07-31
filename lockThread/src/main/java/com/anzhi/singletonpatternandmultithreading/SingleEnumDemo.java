package com.anzhi.singletonpatternandmultithreading;

public class SingleEnumDemo {
    private SingleEnumDemo(){};

    public static enum SingleEnum {
        SINGLETON;

        private SingleEnumDemo INSTANCE = null;

        SingleEnum(){
            INSTANCE = new SingleEnumDemo();
        }

        public SingleEnumDemo getINSTANCE() {
            return INSTANCE;
        }
    }
}
