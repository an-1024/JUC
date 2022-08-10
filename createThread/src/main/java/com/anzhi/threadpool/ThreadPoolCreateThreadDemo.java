package com.anzhi.threadpool;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

import static java.lang.Thread.sleep;

public class ThreadPoolCreateThreadDemo {
    public static void main(String[] args) {
        CompletableFutureCreateThread completableFutureCreateThread = new CompletableFutureCreateThread();
        int number = completableFutureCreateThread.addNumber();
        System.out.println("------------------------" + number);
    }
}
