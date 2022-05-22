package com.anzhi.synchronizedlocktype;

public class LockReentrancySupportsExtendsDemo extends HasSelfPrivateNum{
    synchronized public void lockReentrancySupportsExtends(String userName){
        System.out.println("Thread" + userName + "获得锁 start run");
        synchronizedAddMethodLockReentrancy(userName);
    }

    @Override
    public void synchronizedAddMethod(String userName) {
        System.out.println("LockReentrancySupportsExtendsDemo 重写方法执行");
        lockReentrancySupportsExtends(userName);
    }
}
