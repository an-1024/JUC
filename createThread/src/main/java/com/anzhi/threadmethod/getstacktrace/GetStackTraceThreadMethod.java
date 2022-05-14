package com.anzhi.threadmethod.getstacktrace;


public class GetStackTraceThreadMethod extends Thread{

    private void a(){
        b();
    }

    private void b(){
        c();
    }

    private void c(){
        d();
    }

    private void d(){
        e();
    }

    private void e(){
        StackTraceElement[]  elementArray = Thread.currentThread().getStackTrace();
        if(elementArray != null){
            for (StackTraceElement element : elementArray) {
                System.out.println("className= " + element.getClassName() + "\nmethodName= " + element.getMethodName() +
                        "\nfileName= " + element.getFileName() + "\nlineNumber= " + element.getLineNumber());
            }
        }else{
            System.out.println("线程没有启动");
        }

        StackTraceElement[]  elementArray2 = this.getStackTrace();
        System.out.println("当前线程类 GetStackTraceThreadMethod 大小为= " + elementArray2.length);
        if(elementArray2 != null){
            for (StackTraceElement element : elementArray2) {
                System.out.println("className= " + element.getClassName() + "\nmethodName= " + element.getMethodName() +
                        "\nfileName= " + element.getFileName() + "\nlineNumber= " + element.getLineNumber());
            }
        }else{
            System.out.println("线程没有启动");
        }
    }

    @Override
    public void run() {
        System.out.println("run---------------------------start");
        a();
        System.out.println("run---------------------------end");
    }
}
