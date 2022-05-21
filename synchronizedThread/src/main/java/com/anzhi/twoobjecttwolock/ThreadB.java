package com.anzhi.twoobjecttwolock;

public class ThreadB extends Thread {
    private HasSelfPrivateNum selfPrivateNum;

    ThreadB(HasSelfPrivateNum selfPrivateNum) {
        this.selfPrivateNum = selfPrivateNum;
    }

    @Override
    public void run() {
        selfPrivateNum.addMethod(selfPrivateNum,"b");
    }
}
