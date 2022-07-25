package com.anzhi.reentrantlockconsumerproducer;

public class MyReentrantLockConditionMethodDemoTest {
    public static void main(String[] args) {
        MyReentrantLockConditionMethod conditionMethod = new MyReentrantLockConditionMethod();

        MyReentrantLockConditionConsumerThread[] consumerThreadArray = new MyReentrantLockConditionConsumerThread[10];
        MyReentrantLockConditionProducerThread[] producerThreadArray = new MyReentrantLockConditionProducerThread[10];

        for (int i=0; i<10; i++){
            producerThreadArray[i] = new MyReentrantLockConditionProducerThread(conditionMethod);
            consumerThreadArray[i] = new MyReentrantLockConditionConsumerThread(conditionMethod);

            Thread t1 = new Thread(producerThreadArray[i]);
            Thread t2 = new Thread(consumerThreadArray[i]);

            t1.start();
            t2.start();
        }

    }
}
