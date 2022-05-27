package com.anzhi.expansionofthelock;

import com.anzhi.synchronizedlocktype.HasSelfPrivateNum;
import org.openjdk.jol.info.ClassLayout;

public class SynchronizedExampleBiasLockTurnNnDelay {
    public static void main(String[] args) {
        // jvm 中默认延迟开启偏向锁, 默认 4s 后开启。一旦开启, 不论对象是否被线程持有, 对象都处于偏向锁状态
        try {
            Thread.sleep(5000);
            //Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        // 创建一个对象  偏向锁
        HasSelfPrivateNum hasSelfPrivateNum = new HasSelfPrivateNum();
        synchronized (hasSelfPrivateNum){
            System.out.println("对象正在被加锁-----------");
            System.out.println(ClassLayout.parseInstance(hasSelfPrivateNum).toPrintable());
        }

        System.out.println("线程释放锁-----------------");
        System.out.println(ClassLayout.parseInstance(hasSelfPrivateNum).toPrintable());

    }
}
