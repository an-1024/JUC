package com.anzhi.synchronizedlocktype;

import java.util.Objects;

public class HasSelfPrivateNum {

    private int num = 0;

    // synchronized 修饰普通方法
    synchronized public void synchronizedAddMethod(String userName) {
        System.out.println("Thread" + userName + "获得锁");
        try {
            Thread.sleep(5000);
            System.out.println("Thread" + userName + "释放锁");
        } catch (InterruptedException e) {
            // doNothing
        }
    }

    public void addMethod(String userName) {
        synchronized (this) {
            System.out.println("Thread" + userName + "获得锁");
        }
    }

    // synchronized 锁重入
    synchronized public void synchronizedAddMethodLockReentrancy(String userName) {
        System.out.println("Thread" + userName + "获得锁");
        try {
            addMethodLockReentrancy("ThreadT" + userName + "start run");
            Thread.sleep(5000);
            System.out.println("Thread" + userName + "释放锁");
        } catch (InterruptedException e) {
            // doNothing
        }
    }

    synchronized public void addMethodLockReentrancy(String userName) {
        System.out.println("Thread" + userName + "获得锁执行方法 addMethodLockReentrancy");
    }

    // synchronized 修饰静态方法
    synchronized static public void synchronizedStaticAddMethod() {
        System.out.println("Thread" + Thread.currentThread().getName() + "获得锁");
        try {
            Thread.sleep(5000);
            System.out.println("Thread" + Thread.currentThread().getName() + "释放锁");
        } catch (InterruptedException e) {
            // doNothing
        }
    }

    public static void staticAddMethod() {
        synchronized (HasSelfPrivateNum.class) {
            System.out.println("Thread" + Thread.currentThread().getName() + "获得锁");
        }
    }


    // 异常，锁释放
    synchronized public void synchronizedExceptionMethod(String userName) {
        System.out.println("Thread" + userName + "获得锁");
        try {
            if(Objects.equals(userName, "TA")) {
                int i = 1 / 0;
                Thread.sleep(5000);
            }
            System.out.println("Thread" + userName + "释放锁");
        } catch (Exception e) {
            System.out.println("异常释放锁");
        }
    }

    // 将 String 对象作为锁带来的问题
    public void synchronizedString(String str){
        synchronized (str){
            System.out.println("Thread" + Thread.currentThread().getName() + "获得锁开始执行");
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                // doNothing
            }
            System.out.println("Thread" + Thread.currentThread().getName() + "执行完成, 释放锁");
        }
    }

    public void synchronizedString2(String str){
        synchronized (str){
            System.out.println("Thread" + Thread.currentThread().getName() + "获得锁开始执行");
            System.out.println("Thread" + Thread.currentThread().getName() + "执行完成, 释放锁");
        }
    }
}
