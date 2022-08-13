package com.anzhi.futureservice;

import com.google.common.collect.Lists;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class FutureTaskDemo {
    public static void main(String[] args) throws Exception{
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        List<Callable<Integer>> callableArrayList = Lists.newArrayList(new Callable<Integer>() {
            @Override
            public Integer call() throws Exception {
                System.out.println("---------------" + 1);
                return 1;
            }
        });
        Integer result = executorService.invokeAny(callableArrayList, 1000L, TimeUnit.SECONDS);
        System.out.println("--------------" + result);
    }
}
