package waitnotifyproducerconsumeroperatevalue;

import java.util.concurrent.atomic.AtomicInteger;

public class WaitNotifyProducerConsumerOperateValue {
    private static final Object lock = new Object();

    private static AtomicInteger count = new AtomicInteger();

    public static void main(String[] args) {
        Thread producer = new Thread(new Runnable() {
            public void run() {
                synchronized(lock){
                    System.out.println("生产者开始生产数字 count = " + count.incrementAndGet());
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        // doNothing
                    }
                }
            }
        }, "producer");


        Thread consumer = new Thread(new Runnable() {
            public void run() {
                synchronized (lock){
                    System.out.println("消费者开始消费数字 count = " + count.decrementAndGet());
                    lock.notify();
                }
            }
        }, "consumer");

        producer.start();
        consumer.start();
    }
}
