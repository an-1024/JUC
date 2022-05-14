package com.anzhi.twoobjecttwolock;

import org.openjdk.jol.info.ClassLayout;

public class ThreadB extends Thread {
    private HasSelfPrivateNum selfPrivateNum;

    ThreadB(HasSelfPrivateNum selfPrivateNum) {
        this.selfPrivateNum = selfPrivateNum;
    }

    @Override
    public void run() {
        System.out.println(ThreadB.currentThread().getName() + "----->" + ClassLayout.parseInstance(selfPrivateNum).toPrintable());
        selfPrivateNum.addMethod("b");
    }
}
