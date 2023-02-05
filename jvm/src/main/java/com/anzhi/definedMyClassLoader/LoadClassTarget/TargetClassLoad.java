package com.anzhi.definedMyClassLoader.LoadClassTarget;

public class TargetClassLoad {
    private String pathTest;

    public TargetClassLoad(){}

    public TargetClassLoad(String pathTest){
        this.pathTest = pathTest;
    }

    @Override
    public String toString() {
        return "The Class is TargetClassLoad, pathTest = " + pathTest;
    }
}
