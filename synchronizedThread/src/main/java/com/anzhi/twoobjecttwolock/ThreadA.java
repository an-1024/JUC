package com.anzhi.twoobjecttwolock;

import org.openjdk.jol.info.ClassLayout;

public class ThreadA extends Thread {
    private HasSelfPrivateNum selfPrivateNum;

    ThreadA(HasSelfPrivateNum selfPrivateNum) {
        this.selfPrivateNum = selfPrivateNum;
    }

    @Override
    public void run() {
        System.out.println(ThreadA.currentThread().getName() + "----->" + ClassLayout.parseInstance(selfPrivateNum).toPrintable());
        selfPrivateNum.synchronizedAddMethod("a");
    }
}
