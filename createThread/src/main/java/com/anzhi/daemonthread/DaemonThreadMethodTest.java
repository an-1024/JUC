package com.anzhi.daemonthread;

public class DaemonThreadMethodTest extends Thread{
    public static void main(String[] args) {
        try{
            // 设置一个钩子线程， 在 JVM 退出时输出日志
            Runtime.getRuntime().addShutdownHook(new Thread(()-> System.out.println("The JVM exit success !!!")));
            DaemonThreadMethodA threadMethodA = new DaemonThreadMethodA();
            threadMethodA.setDaemon(true);
            threadMethodA.setName("threadMethodA");
            threadMethodA.start();
            Thread.sleep(5000);

            System.out.println("我离开 thread 对象也不再打印了，也就是停止了");
        }catch (InterruptedException e){

        }
    }
}
