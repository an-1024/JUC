package com.anzhi.threadpollprocess;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ThreadPoolFactoryDestory {

    public static void main(String[] args) throws InterruptedException {
        // 关闭线程池的正常流程
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(Runtime.getRuntime().availableProcessors(), Runtime.getRuntime().availableProcessors() * 2 -1,
                600L, TimeUnit.SECONDS,
                new LinkedBlockingQueue<>(5),
                new NamedThreadFactory("threadPoolDemo"),
                new ThreadPoolExecutor.DiscardOldestPolicy());

        threadPoolExecutor.shutdown();
        threadPoolExecutor.awaitTermination(1, TimeUnit.SECONDS);
    }
}
