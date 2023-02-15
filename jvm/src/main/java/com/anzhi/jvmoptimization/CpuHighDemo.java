package com.anzhi.jvmoptimization;

/**
 * 不停地向栈中添加方法
 */
public class CpuHighDemo {
    private static int count = 1;
    private static void compute(){

    }

    public static void main(String[] args) {
        while(true){
            compute();
        }
    }
}