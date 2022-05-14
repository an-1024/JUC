package com.anzhi.twoobjecttwolock;

public class HasSelfPrivateNum {

    private int num = 0;

    synchronized public void synchronizedAddMethod(String userName) {
        try {
            if (userName.equals("a")) {
                num = 100;
                System.out.println("a set over!");
                Thread.sleep(2000);
            } else {
                num = 200;
                System.out.println("b set over!");
            }
            System.out.println(userName + " num = " + num);
        } catch (Exception e) {

        }
    }

    synchronized public void addMethod(String userName) {
        num += 100;
        System.out.println("addMethod= " + userName + " num= " + num);
    }
}
