package com.anzhi.classload;

/**
 * 类加载演示
 */
public class ClassLoadExample {
    public static void myPrintf(){ // 一个方法对应一块栈帧内存区域
        System.out.println("类加载");
    }

    public static void main(String[] args) {
        myPrintf();
    }
}
