package com.anzhi.expansionofthelock;

import com.anzhi.synchronizedlocktype.HasSelfPrivateNum;
import org.openjdk.jol.info.ClassLayout;

public class SynchronizedHashCodeLock {
    public static void main(String[] args) {
        // 延时 4s 等待偏向锁的开启
        try {
            Thread.sleep(4002);
        } catch (InterruptedException e) {
            // doNothing
        }
        // 此时对象默认偏向锁, 即使对象无线程竞争
        HasSelfPrivateNum selfPrivateNum = new HasSelfPrivateNum();
        System.out.println("主程序延时 4s 等待偏向锁开启 即使对象无线程竞争 hasSelfPrivateNum 对象为偏向锁: " + ClassLayout.parseInstance(selfPrivateNum).toPrintable());
        synchronized (selfPrivateNum){
            System.out.println("selfPrivateNum 对象第一次加锁, hasSelfPrivateNum 对象为偏向锁" + ClassLayout.parseInstance(selfPrivateNum).toPrintable());
        }
        new Thread(()->{
            synchronized (selfPrivateNum){
                selfPrivateNum.hashCode();
                System.out.println("selfPrivateNum 计算 hashCode 后, 第二次加锁, hasSelfPrivateNum 对象为重量级锁" + ClassLayout.parseInstance(selfPrivateNum).toPrintable());
            }
        }, "ThreadB").start();
    }
}
