package com.anzhi.expansionofthelock;

import com.anzhi.synchronizedlocktype.HasSelfPrivateNum;
import org.openjdk.jol.info.ClassLayout;
import org.openjdk.jol.vm.VM;

public class SynchronizedExampleNoLock {
    public static void main(String[] args) {
        // 输出虚拟机的情况
        System.out.println(VM.current().details());

        // 创建一个对象
        HasSelfPrivateNum hasSelfPrivateNum = new HasSelfPrivateNum();
        System.out.println(ClassLayout.parseInstance(hasSelfPrivateNum).toPrintable());
    }
}
