package com.anzhi.twoobjecttwolock;

public class ThreadTest {
    public static void main(String[] args) {
        HasSelfPrivateNum threadA = new HasSelfPrivateNum();
        HasSelfPrivateNum threadB = new HasSelfPrivateNum();


        ThreadA tA = new ThreadA(threadA);
        ThreadB tB = new ThreadB(threadA);

        tA.setName("TA");
        tB.setName("tB");

        tA.start();
        tB.start();
    }
}
