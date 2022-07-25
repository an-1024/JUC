package com.anzhi.lockmethodsuse;

import java.util.concurrent.locks.ReentrantLock;

public class GetholdCountMethodDemoTest {
    public static void main(String[] args) {
        GetholdCountMethodDemo holdCountMethodDemo = new GetholdCountMethodDemo();
        holdCountMethodDemo.lockMethod1();
    }
}
