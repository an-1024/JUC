package com.anzhi.twoobjecttwolock;

import org.openjdk.jol.info.ClassLayout;

public class HasSelfPrivateNum {

    private int num = 0;

    synchronized public void synchronizedAddMethod(HasSelfPrivateNum hasSelfPrivateNum, String userName) {
        if (userName.equals("a")) {
            System.out.println("a 线程获得锁, 对象头信息为: " + ClassLayout.parseInstance(hasSelfPrivateNum).toPrintable());
            System.out.println("a start run");
            num = 100;
            System.out.println("a set over!");
        } else {
            System.out.println("b 线程获得锁, 对象头信息为: " + ClassLayout.parseInstance(hasSelfPrivateNum).toPrintable());
            System.out.println("b start run");
            num = 200;
            System.out.println("b set over!");
        }
        System.out.println(userName + " num = " + num);
    }

    public void addMethod(HasSelfPrivateNum hasSelfPrivateNum, String userName) {
        System.out.println("b 线程获得锁, 对象头信息为: " + ClassLayout.parseInstance(hasSelfPrivateNum).toPrintable());
        num += 100;
        System.out.println("addMethod=" + userName + " num= " + num);
    }
}
