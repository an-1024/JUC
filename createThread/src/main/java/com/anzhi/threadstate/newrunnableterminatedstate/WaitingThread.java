package com.anzhi.threadstate.newrunnableterminatedstate;

public class WaitingThread extends Thread{
    @Override
    public void run() {
        synchronized (WaitingLock.lock){
            try {
                WaitingLock.lock.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
