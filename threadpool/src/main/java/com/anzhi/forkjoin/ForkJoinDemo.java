package com.anzhi.forkjoin;

import com.anzhi.threadpollprocess.NamedThreadFactory;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * 使用 ScheduleThreadPoolExecutor 实现任务拆分
 */
public class ForkJoinDemo {
    public static void main(String[] args) {
        // 线程池核心线程数要 > 1,因为该线程池队列是无界的，所以只有核心线程数参数有效；
        // 只设置一个核心线程，在任务 TaskA 执行的时候，TaskA1，TaskA2 都会放入队列，此时 TaskA 在等待 TaskA1、A2 的返回结果阻塞
        // TaskA1 需要等待自己的返回结果阻塞，但是因为核心线程被 TaskA 占用，最终导致 TaskA1 一致阻塞，最终导致 TaskA 阻塞
        // 我是这样理解的
        ScheduledThreadPoolExecutor scheduledThreadPoolExecutor = new ScheduledThreadPoolExecutor(1);

        Future<?> future = scheduledThreadPoolExecutor.submit(new TaskA(scheduledThreadPoolExecutor));
        try {
            // 获取结果阻塞
            future.get();
            System.out.println("TaskA 执行成功");
        } catch (InterruptedException e) {
            // doNothing
        } catch (ExecutionException e) {
            // doNothing
        } finally {
            scheduledThreadPoolExecutor.shutdown();
            try {
                scheduledThreadPoolExecutor.awaitTermination(1, TimeUnit.MINUTES);
            } catch (InterruptedException e) {
                // doNothing
            }
        }
    }

    static class TaskA implements Runnable {
        private ScheduledThreadPoolExecutor scheduledTaskA;

        public TaskA(ScheduledThreadPoolExecutor executor) {
            this.scheduledTaskA = executor;
        }

        @Override
        public void run() {
            System.out.println("TaskA start");
            Future<?> futureTaskA1 = scheduledTaskA.submit(new TaskA1());
            Future<?> futureTaskA2 = scheduledTaskA.submit(new TaskA2());
            try {
                futureTaskA2.get();
                futureTaskA1.get();
            } catch (InterruptedException e) {
                // doNothing
            } catch (ExecutionException e) {
                // doNothing
            }
            System.out.println("TaskA ended");
        }
    }

    static class TaskA1 implements Runnable {
        @Override
        public void run() {
            System.out.println("A1 start success");
        }
    }

    static class TaskA2 implements Runnable {
        @Override
        public void run() {
            System.out.println("A2 start success");
        }
    }
}
