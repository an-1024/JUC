package com.anzhi.constantpool;

public class ConstantPoolDemo {
    public static void main(String[] args) {
        String s1 = new String("zhangsan");
        System.out.println(s1==s1.intern());

        String s2 = "zhangsan";
        System.out.println(s2==s2.intern());
    }
}
