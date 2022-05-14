package com.anzhi.threadmethod.suspendmethod;

public class SuspendThreadObjectTest {
    public static void main(String[] args) {
        try{
            final SuspendThreadObject object = new SuspendThreadObject();

            Thread thread = new Thread() {
                @Override
                public void run() {
                    object.printString();
                }
            };

            thread.setName("a");
            thread.start();

            Thread.sleep(1000);

            Thread thread2 = new Thread() {
                @Override
                public void run() {
                    System.out.println("thread2 启动了，但是无法进入 printString() 方法，只打印个begin");
                    System.out.println("因为printString()方法被a线程锁定并且永远被 suspend 暂停了");
                    object.printString();
                }
            };
            thread2.setName("b");
            thread2.start();
        }catch (InterruptedException e){
            // doNothing
        }
    }
}
