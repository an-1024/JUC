package com.anzhi.threadpool;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class CompletableFutureCreateThread {

    private static ThreadPoolExecutor CREATE_THREAD_BY_POOL = new ThreadPoolExecutor(Runtime.getRuntime().availableProcessors(),
            Runtime.getRuntime().availableProcessors() * 2 - 1, 10, TimeUnit.SECONDS,
            new LinkedBlockingDeque<>(20),
            new NamedThreadFactory("CREATE_THREAD_BY_POOL")
    );

    private static AtomicInteger atomicInteger = new AtomicInteger(0);

    private static AtomicInteger result = new AtomicInteger(0);

    public int addNumber(){
        for(int i = 0; i<2000; i++) {
            CompletableFuture<AtomicInteger> voidCompletableFuture = CompletableFuture.supplyAsync(() -> addNumber(atomicInteger));
            try {
                result.set(voidCompletableFuture.get().get());
            } catch (InterruptedException e) {
                // doNothing
            } catch (ExecutionException e) {
                // doNothing
            }
        }
        return result.get();
    }

    private AtomicInteger addNumber(AtomicInteger atomicInteger){
        atomicInteger.getAndIncrement();
        return atomicInteger;
    }
}
