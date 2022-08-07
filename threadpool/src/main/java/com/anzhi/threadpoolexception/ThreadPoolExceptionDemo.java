package com.anzhi.threadpoolexception;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 *  验证线程池提交任务异常不会抛出
 */
public class ThreadPoolExceptionDemo {
    private static final ThreadPoolExecutor EXCEPTION_TEST_EXECUTOR = new ThreadPoolExecutor(20, 20, 0, TimeUnit.SECONDS, new LinkedBlockingQueue<>(100000));

    public static void main(String[] args) {
        try {
            EXCEPTION_TEST_EXECUTOR.submit(() -> {
                int i = 1 / 0;
            });
        }catch (Exception e){
            System.out.println("执行异常");
        }
    }
}
