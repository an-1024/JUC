package com.anzhi.threadcreate;

public class CreateThreadByExtendsThread extends Thread{
    @Override
    public void run() {
        System.out.println("Create Thread by Extends Thread Begin to Run!");
    }
}
