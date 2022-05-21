package com.anzhi.twoobjecttwolock;

public class ThreadA extends Thread {
    private HasSelfPrivateNum selfPrivateNum;

    ThreadA(HasSelfPrivateNum selfPrivateNum) {
        this.selfPrivateNum = selfPrivateNum;
    }

    @Override
    public void run() {
        selfPrivateNum.synchronizedAddMethod(selfPrivateNum, "a");
    }
}
