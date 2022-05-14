package com.anzhi.threadmethod.interrupmethod;

public class InterruptThreadMethod extends Thread{
    @Override
    public void run() {
        try {
            for (int i = 0; i < 4; i++) {
                System.out.println("i=" + (i + 1));
                if (this.isInterrupted()) {
                    System.out.println("线程已经是停止状态! 线程退出循环");
                    throw new InterruptedException();
                }
            }
            System.out.println("GetIdThreadMethod 是否被中断1= " + this.interrupted());
            System.out.println("GetIdThreadMethod 是否被中断2= " + this.interrupted());
        }catch(InterruptedException e){
            System.out.println("进入 InterruptThreadMethod 类中的 run 方法 catch 异常");
        }
    }
}
