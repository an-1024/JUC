package com.anzhi.threadmethod.getallstacktraces;

import java.util.Iterator;
import java.util.Map;

public class GetAllStackTracesMethod extends Thread{
    private void a(){
        b();
    }

    private void b() {
        c();
    }

    private void c() {
        d();
    }

    private void d() {
        e();
    }

    private void e() {
        Map<Thread,StackTraceElement[]> map = Thread.currentThread().getAllStackTraces();
        if(map != null && map.size() != 0){
            Iterator keyIterator = map.keySet().iterator();
            while(keyIterator.hasNext()){
                Thread eachThread = (Thread) keyIterator.next();
                StackTraceElement[] array = map.get(eachThread);
                System.out.println("-----------------每个线程的基本信息");
                System.out.println("线程名称：" + eachThread.getName());
                System.out.println("线程分组：" + eachThread.getThreadGroup().getName());
                System.out.println("StackTraceElement[].length= " + array.length);
                System.out.println("线程的状态：" + eachThread.getState());

                if(array.length != 0){
                    System.out.println("输出 StackTraceElement[] 数组具体信息：");
                    for (StackTraceElement element : array) {
                        System.out.println("className= " + element.getClassName() + "  fileName=" +
                                element.getFileName() + "   lineNumber= " + element.getLineNumber() + "   methodName=: " + element.getMethodName());
                    }
                }else{
                    System.out.println("没有StackTraceElement[] 信息，因为线程：" + eachThread.getName()
                            + "中的StackTraceElement[].length=0");
                }
            }
        }
    }

    @Override
    public void run() {
        a();
    }
}
