package com.anzhi.threadmethod.dumpStack;

public class DumpStackThreadMethod extends Thread{

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
    private void e(){
        int age = 100;
        if(age == 100){
            Thread.dumpStack();
        }
    }

    @Override
    public void run() {
        e();
    }
}
