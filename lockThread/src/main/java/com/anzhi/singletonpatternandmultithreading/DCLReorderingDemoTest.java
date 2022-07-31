package com.anzhi.singletonpatternandmultithreading;

import java.util.Random;
import java.util.concurrent.CountDownLatch;

/**
 * 验证重排序
 */
public class DCLReorderingDemoTest {
    public static void main(String[] args) {
        for(;;){
            CountDownLatch latch = new CountDownLatch(1);
            CountDownLatch end = new CountDownLatch(100);
            for (int i=0; i<100; i++) {
                Thread t1 =  new Thread(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            latch.await();
                            DCLReorderingDemo one = DCLReorderingDemo.getInstance();
                            if (one.i_am_has_state == 0) {
                                System.out.println("one.i_am_has_state == 0 进程结束");
                                System.exit(0);
                            }
                            end.countDown();
                        } catch (InterruptedException e) {
                            // doNothing
                        }
                    }
                });

                t1.start();
            }
            latch.countDown();
            try {
                end.await();
            } catch (InterruptedException e) {
                // doNothing
            }
            DCLReorderingDemo.reset();
        }
    }
}
