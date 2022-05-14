package com.anzhi.threadpriority.threadpirorityeffectiv;

public class ThreadExecuteEffectivTest {
    public static void main(String[] args) {
        try{
            ThreadExecuteEffectivA threadExecuteEffectivA = new ThreadExecuteEffectivA();
            threadExecuteEffectivA.setName("threadExecuteEffectivA");
            threadExecuteEffectivA.setPriority(Thread.NORM_PRIORITY - 3);

            ThreadExecuteEffectivB threadExecuteEffectivB = new ThreadExecuteEffectivB();
            threadExecuteEffectivB.setName("threadExecuteEffectivB");
            threadExecuteEffectivB.setPriority(Thread.NORM_PRIORITY + 4);

            threadExecuteEffectivA.start();
            threadExecuteEffectivB.start();

            Thread.sleep(1000);
            threadExecuteEffectivA.stop();
            threadExecuteEffectivB.stop();


            System.out.println("threadExecuteEffectivA.getCount()" + threadExecuteEffectivA.getCount());
            System.out.println("threadExecuteEffectivB.getCount()" + threadExecuteEffectivB.getCount());

            System.out.println("threadExecuteEffectivA.getCount() - threadExecuteEffectivB.getCount() = " + (threadExecuteEffectivA.getCount() - threadExecuteEffectivB.getCount()));
        }catch (InterruptedException e){

        }
    }
}
