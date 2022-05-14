package com.anzhi.threadstate.newrunnableterminatedstate;

public class BlockedThread2 extends Thread{
    @Override
    public void run() {
        BlockedThreadService.serviceMethod();
    }
}
