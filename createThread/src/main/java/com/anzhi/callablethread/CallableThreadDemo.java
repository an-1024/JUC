package com.anzhi.callablethread;

import java.util.concurrent.Callable;

public class CallableThreadDemo implements Callable<String> {
    @Override
    public String call() throws Exception {
        System.out.println("实现 Callable 接口，使用 FutureTask 封装");
        return "CallableThreadDemo start execute";
    }
}
