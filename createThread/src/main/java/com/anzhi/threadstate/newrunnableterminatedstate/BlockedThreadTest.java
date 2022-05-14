package com.anzhi.threadstate.newrunnableterminatedstate;

public class BlockedThreadTest {
    public static void main(String[] args) {
        try {
            BlockedThread thread = new BlockedThread();
            thread.setName("BlockedThread");
            thread.start();
            Thread.sleep(10);

            BlockedThread2 thread2 = new BlockedThread2();
            thread2.setName("BlockedThread2");
            thread2.start();
            Thread.sleep(10);
            System.out.println("main 方法中 thread2 线程状态：" + thread2.getState());
        }catch (InterruptedException e){
            // doNothing
        }
    }
}
