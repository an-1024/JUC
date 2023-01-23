package com.anzhi.scheduleexecutor;


import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ScheduleExecutorDemo {
    public static void main(String[] args) {
        // 创建延时线程池
        ScheduledThreadPoolExecutor executor = new ScheduledThreadPoolExecutor(1);
        // 延时任务执行 延迟 1s
        executor.schedule(new Runnable() {
            @Override
            public void run() {
                System.out.printf("<h1>Thread-A更新成功</h1><h1>耗时: %sm", System.currentTimeMillis()/1000);
                System.out.println();
            }
        }, 1, TimeUnit.SECONDS);
        // 按照周期执行, 不延时，
        executor.scheduleAtFixedRate(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    // doNothing
                }
                System.out.printf("<h1>Thread-B更新成功</h1><h1>耗时: %sm", System.currentTimeMillis()/1000);
                System.out.println();
            }
        }, 0, 2, TimeUnit.SECONDS);

        // 按照周期执行，延时, 从延时之后的时间开始算起
        executor.scheduleAtFixedRate(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    // doNothing
                }
                System.out.printf("<h1>Thread-C更新成功</h1><h1>耗时: %sm", System.currentTimeMillis()/1000);
                System.out.println();
            }
        }, 2, 2, TimeUnit.SECONDS);
    }
}
