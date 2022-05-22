package com.anzhi.synchronizedlocktype;

public class ThreadTest {
    public static void main(String[] args) {
        HasSelfPrivateNum hasSelfPrivateNum = new HasSelfPrivateNum();

        // 验证同步方法上锁的是对象
//        new Thread(()->hasSelfPrivateNum.synchronizedAddMethod("TA")).start();
//        new Thread(()->hasSelfPrivateNum.addMethod("TB")).start();

        // 验证修饰静态同步方法，锁是当前类的 Class 对象
//        HasSelfPrivateNum hasSelfPrivateNum2 = new HasSelfPrivateNum();
//        new Thread(() -> HasSelfPrivateNum.synchronizedStaticAddMethod(), "TA").start();
//        new Thread(() -> hasSelfPrivateNum2.staticAddMethod(), "TB").start();

        // 锁重入
//        new Thread(() -> hasSelfPrivateNum.synchronizedAddMethodLockReentrancy("TA")).start();

        // 锁重入支持继承
//        LockReentrancySupportsExtendsDemo lockReentrancySupportsExtends = new LockReentrancySupportsExtendsDemo();
//        new Thread(() -> lockReentrancySupportsExtends.lockReentrancySupportsExtends("lockReentrancySupportsExtends")).start();


        // 异常释放锁
//        HasSelfPrivateNum selfPrivateNum = new HasSelfPrivateNum();
//        new Thread(() -> selfPrivateNum.synchronizedExceptionMethod("TA"), "TA").start();
//        new Thread(() -> selfPrivateNum.synchronizedExceptionMethod("TB"), "TB").start();

        // 重写同步方法不使用 synchronized 修饰, 如果在非同步方法中调用了同步方法, 该方法同步样会变成同步方法
//        LockReentrancySupportsExtendsDemo supportsExtendsDemo = new LockReentrancySupportsExtendsDemo();
//        new Thread(() -> supportsExtendsDemo.lockReentrancySupportsExtends("TA"), "TA").start();
//        new Thread(() -> supportsExtendsDemo.lockReentrancySupportsExtends("TB"), "TB").start();

        // String 作为锁对象的问题
        HasSelfPrivateNum selfPrivateNum = new HasSelfPrivateNum();
        new Thread(() -> selfPrivateNum.synchronizedString("AA"), "TA").start();
        new Thread(() -> selfPrivateNum.synchronizedString2("AA"), "TB").start();
    }
}
