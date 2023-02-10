package com.anzhi.finalizedgc;

import sun.misc.GC;

import java.util.ArrayList;
import java.util.List;

public class GCObject {
    private List<GCObject> gcObjectList = new ArrayList<>();

    private int id;
    private String name;

    public GCObject(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    protected void finalize() throws Throwable {
        gcObjectList.add(this);
        System.out.println("GCObject 将要被回收，id = " + id + " name=" + name);
    }
}
