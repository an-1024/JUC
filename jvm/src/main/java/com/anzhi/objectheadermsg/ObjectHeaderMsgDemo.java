package com.anzhi.objectheadermsg;

import org.openjdk.jol.info.ClassLayout;

/**
 * 查看对象大小
 */
public class ObjectHeaderMsgDemo {
    public static void main(String[] args) {
        System.out.println("------------------Object对象头-----------------");
        ClassLayout layout = ClassLayout.parseInstance(new Object());
        System.out.println(layout.toPrintable());

        System.out.println("------------------数组对象---------------------");
        ClassLayout layout1 = ClassLayout.parseInstance(new int[]{});
        System.out.println(layout1.toPrintable());

        System.out.println("------------------我们创建的对象----------------");
        ClassLayout layout2 = ClassLayout.parseInstance(new MyClass());
        System.out.println(layout2.toPrintable());
    }

   static class MyClass {
        int id;
        String name;
        byte b;
        Object o;
    }
}
