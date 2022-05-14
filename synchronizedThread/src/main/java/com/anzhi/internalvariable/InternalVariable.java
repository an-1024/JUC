package com.anzhi.internalvariable;

public class InternalVariable {

    int num = 0; // 实例变量


    public synchronized void addI(String username){
        //int num = 0;  //局部内变量
        if(username.equals("a")){
            num = 100;
            System.out.println("Thread.currentThread().getName()= " + Thread.currentThread().getName());
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("a set over");
        }else{
            num = 200;
            System.out.println("Thread.currentThread().getName()= " + Thread.currentThread().getName());
        }
        System.out.println(username + " num = " + num);
    }

}
