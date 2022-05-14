package com.anzhi.threadmethod.getstacktrace;

public class GetStackTraceThreadMethodTest {
    
    public static void main(String[] args) {
//        // 直接启动线程
//        GetStackTraceThreadMethod stackTraceThreadMethod = new GetStackTraceThreadMethod();
//        stackTraceThreadMethod.setName("getStackTrace");
//        stackTraceThreadMethod.start();

        // 作为构造参数传入
        GetStackTraceThreadMethod stackTraceThreadMethod1 = new GetStackTraceThreadMethod();
        Thread t= new Thread(stackTraceThreadMethod1);
        t.setName("getStackTrace2");
        t.start();
    }
}
