package com.anzhi.threadmethod.suspendmethod;

public class SuspendDataMiss {
    private String username = "1";
    private String password = "11";

    public void setValue(String username, String password){
        this.username = username;
        if(Thread.currentThread().getName().equals("a")){
            System.out.println("停止 a 线程");
            Thread.currentThread().suspend();
        }
        this.password = password;
    }

    public void printUserNamePPassword(){
        System.out.println(username + "  " + password);
    }
}
