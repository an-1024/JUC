package com.anzhi.twoobjecttwolock;

public class ThreadTest {
    public static void main(String[] args) {

        HasSelfPrivateNum threadA = new HasSelfPrivateNum();
        HasSelfPrivateNum threadB = new HasSelfPrivateNum();


        ThreadA tA = new ThreadA(threadA);
        tA.setName("TA");
        tA.start();


        /**
         * 验证修饰普通方法，synchronized作用的是当前实例对象
         */
        ThreadB tB = new ThreadB(threadB);
        tB.setName("tB");
        tB.start();
    }
}
