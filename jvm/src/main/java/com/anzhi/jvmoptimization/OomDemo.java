package com.anzhi.jvmoptimization;

import java.util.ArrayList;
import java.util.List;

/**
 * 测试 OOM
 * 设置 JVM 运行参数：-Xms10M -Xmx10M -XX:+PrintGCDetails -XX:+HeapDumpOnOutOfMemoryError -XX:HeapDumpPath=/Users/azh/Dev_AZH/Java_St/JUC/jvm/src/main/java/com/anzhi/jvmoptimization/oom.dump
 */
public class OomDemo {
    public static List<Object> objectList = new ArrayList<>();

    public static void main(String[] args) {
        int i=0;
        int j=0;
        while(true){
            objectList.add(new Object());
        }
    }
}
