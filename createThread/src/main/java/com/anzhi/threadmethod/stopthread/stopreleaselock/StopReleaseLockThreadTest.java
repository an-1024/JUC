package com.anzhi.threadmethod.stopthread.stopreleaselock;

public class StopReleaseLockThreadTest {
    public static void main(String[] args) {
        try {
            StopReleaseLockService stopReleaseLockService = new StopReleaseLockService();
            StopReleaseLockThreadA threadA = new StopReleaseLockThreadA(stopReleaseLockService);
            threadA.start();  // username = "b"，
            Thread.sleep(100);  // sleep 并不释放锁， 此时 password = "aa", 因为 threadA 也调用了 sleep(100000)
            StopReleaseLockThreadB stopReleaseLockThreadB = new StopReleaseLockThreadB(stopReleaseLockService);
            StopReleaseLockThreadB threadB = new StopReleaseLockThreadB(stopReleaseLockService);
            threadB.start();
            Thread.sleep(300);
            threadA.stop();  // 线程 ThreadA 强行停止，但是 password 仍然为 aa 释放锁，线程 threadB 执行，打印 username，password，
            System.out.println("stop 执行后， 在下方开始打印 username 和 password");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
