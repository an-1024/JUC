package com.anzhi.threecolormodel;


/**
 * 三色标记模型
 */
public class ThreeColorModelDemo {
    public static void main(String[] args) {
        MarkA markA = new MarkA();
        // 开始做并发标记，标记根结点的引用

    }

    static class MarkA {
        MarkB markB = new MarkB();
    }

    static class MarkB{
        MarkC markC = new MarkC();
        MarkD markD = null;

    }

    static class MarkC{

    }

    static class MarkD{

    }
}
