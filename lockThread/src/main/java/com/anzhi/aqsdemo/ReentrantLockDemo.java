package com.anzhi.aqsdemo;

import java.util.concurrent.locks.ReentrantLock;

/**
 * 通过这个买票 demo 来观察独占锁的实现
 */
public class ReentrantLockDemo {
    // 默认非公平锁
    private final ReentrantLock lock = new ReentrantLock(); 
    // 总票数
    private static int tickets = 8;
 
    public void buyTicket() {
        // 获取锁
        lock.lock();
        // 还有票继续卖
        if (tickets > 0) {
            try {
                Thread.sleep(10);
                System.out.println(Thread.currentThread().getName() + "购买了第" + tickets-- + "张票");
            } catch (InterruptedException e) {
                // doNothing
            } finally {
                lock.unlock();
            }
        }
    }

    public static void main(String[] args) {
        ReentrantLockDemo ticketSystem = new ReentrantLockDemo();
        // 创建多线程购票
        for (int i=1; i<=10;i++) {
            Thread thread = new Thread(()->{
                // 开始购票
                ticketSystem.buyTicket();
            }, "线程" + i);
            // 启动线程
            thread.start();
        }
    }
}
