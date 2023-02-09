package com.anzhi.jvmminorgc;

/**
 * 添加 JVM 运行参数：-XX:+PrintGCDetails
 * 观察 Eden 区到 Survivor 区
 */
public class MinorGcEdenDemo {
    public static void main(String[] args) {
        byte[] allocation1, allocation2;
        // 创建一个 242m 大小的数组对象 占满 Eden 区
        allocation1 = new byte[242000*1024];
        // 再创建一个 8m 大小的数据对象
        allocation2 = new byte[8000*1024];
    }
}
