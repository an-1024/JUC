package com.anzhi.finalizedgc;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * 测试 finalize 方法
 */
public class FinalizeGcDemo {
    public static void main(String[] args) {
        List<GCObject> gcObjects = new ArrayList<>();

        int i=0;
        int j=1000000;
        boolean flag = true;
        while (flag){
            gcObjects.add(new GCObject(i++, UUID.randomUUID().toString()));
            new GCObject(j--, UUID.randomUUID().toString());
            if(j<0){
                flag = false;
            }
        }
    }
}
