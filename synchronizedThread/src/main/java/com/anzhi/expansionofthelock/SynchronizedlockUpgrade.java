package com.anzhi.expansionofthelock;

import com.anzhi.synchronizedlocktype.HasSelfPrivateNum;
import org.openjdk.jol.info.ClassLayout;

/**
 * 锁升级的验证
 */
public class SynchronizedlockUpgrade {
    public static void main(String[] args) {
        // 放在延时前，JVM未开启偏向锁，创建的c1对象，会出现一个问题，它会直接从无锁升级为轻量级锁
        HasSelfPrivateNum selfPrivateNum = new HasSelfPrivateNum();
        System.out.println("未关闭偏向锁的延时: selfPrivateNum 对象无锁: " + ClassLayout.parseInstance(selfPrivateNum).toPrintable());
        synchronized (selfPrivateNum){
            System.out.println("selfPrivateNum 对象第一次加锁, selfPrivateNum 对象为轻量级锁" + ClassLayout.parseInstance(selfPrivateNum).toPrintable());
        }
        // 延时 4s 等待偏向锁的开启
        try {
            Thread.sleep(4001);
        } catch (InterruptedException e) {
            // doNothing
        }
        // 此时对象默认偏向锁, 即使对象无线程竞争
        HasSelfPrivateNum hasSelfPrivateNum = new HasSelfPrivateNum();
        System.out.println("主程序延时 4s 偏向锁开启 即使对象无线程竞争 hasSelfPrivateNum 对象为偏向锁: " + ClassLayout.parseInstance(hasSelfPrivateNum).toPrintable());
        synchronized (hasSelfPrivateNum){
            System.out.println("hasSelfPrivateNum 对象第一次加锁, hasSelfPrivateNum 对象为偏向锁" + ClassLayout.parseInstance(hasSelfPrivateNum).toPrintable());
        }

        // 计算对象的 HashCode, 偏向锁撤销
        hasSelfPrivateNum.hashCode();
        System.out.println("hasSelfPrivateNum 对象计算HashCode, hasSelfPrivateNum 对象为无锁状态" + ClassLayout.parseInstance(hasSelfPrivateNum).toPrintable());
        new Thread(()->{
            synchronized (hasSelfPrivateNum){
                System.out.println("hasSelfPrivateNum 对象不存在线程竞争, hasSelfPrivateNum 对象为轻量级锁" + ClassLayout.parseInstance(hasSelfPrivateNum).toPrintable());
            }
        }, "TA").start();

        new Thread(()->{
            synchronized (hasSelfPrivateNum){
                System.out.println("hasSelfPrivateNum 对象存在线程竞争, hasSelfPrivateNum 对象为轻量级锁" + ClassLayout.parseInstance(hasSelfPrivateNum).toPrintable());
            }
        }, "TB").start();
    }
}
