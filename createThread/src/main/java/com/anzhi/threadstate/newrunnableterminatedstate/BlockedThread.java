package com.anzhi.threadstate.newrunnableterminatedstate;

public class BlockedThread extends Thread{
    @Override
    public void run() {
        BlockedThreadService.serviceMethod();
    }
}
