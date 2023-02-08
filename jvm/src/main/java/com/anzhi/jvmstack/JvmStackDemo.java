package com.anzhi.jvmstack;

/**
 * 对象在栈上分、标量替换示例
 * 分配一亿个对象：如果是分配到堆上，大概需要1GB以上堆空间，如果堆空间小于该值，必然会触发GC。
 * 使用如下参数不会发生GC：
 * ‐Xmx15m ‐Xms15m ‐XX:+DoEscapeAnalysis ‐XX:+PrintGC ‐XX:+EliminateAllocations
 * 使用如下参数都会发生大量GC
 * ‐Xmx15m ‐Xms15m ‐XX:‐DoEscapeAnalysis ‐XX:+PrintGC ‐XX:+EliminateAllocations
 * ‐Xmx15m ‐Xms15m ‐XX:+DoEscapeAnalysis ‐XX:+PrintGC ‐XX:‐EliminateAllocations
 */
public class JvmStackDemo {
    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        for (int i = 0; i < 100000000; i++) {
            alloc();
        }
        long end = System.currentTimeMillis();
        System.out.println(end - start);
    }

    private static void alloc() {
        ObjectStack stack = new ObjectStack();
        stack.setId(1);
    }
}
