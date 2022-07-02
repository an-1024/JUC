package waitnotifycounsumerproducerthreadoperatestack;

public class WaitNotifyProducerConsumerOperateStackDemo_2 {
    public static void main(String[] args) throws InterruptedException {
        MyStack_2 myStack_2 = new MyStack_2();

        ConsumerThread_2 consumerThread_2A = new ConsumerThread_2(myStack_2);
        ConsumerThread_2 consumerThread_2B = new ConsumerThread_2(myStack_2);
        ConsumerThread_2 consumerThread_2C = new ConsumerThread_2(myStack_2);
        ConsumerThread_2 consumerThread_2D = new ConsumerThread_2(myStack_2);
        ConsumerThread_2 consumerThread_2E = new ConsumerThread_2(myStack_2);

        ProducerThread_2 producerThread_2 = new ProducerThread_2(myStack_2);

        Thread c_ThreadA = new Thread(consumerThread_2A);
        Thread c_ThreadB = new Thread(consumerThread_2B);
        Thread c_ThreadC = new Thread(consumerThread_2C);
        Thread c_ThreadD = new Thread(consumerThread_2D);
        Thread c_ThreadE = new Thread(consumerThread_2E);


        Thread p_Thread = new Thread(producerThread_2);

        c_ThreadA.setName("c_ThreadA");
        c_ThreadB.setName("c_ThreadB");
        c_ThreadC.setName("c_ThreadC");
        c_ThreadD.setName("c_ThreadD");
        c_ThreadE.setName("c_ThreadE");

        p_Thread.setName("p_ThreadA");


        c_ThreadA.start();
        c_ThreadB.start();
        c_ThreadC.start();
        c_ThreadD.start();
        c_ThreadE.start();

        p_Thread.start();
        
        Thread.sleep(5000);
        Thread[] threads = new Thread[Thread.currentThread().getThreadGroup().activeCount()];
        Thread.currentThread().getThreadGroup().enumerate(threads);
        
        for(Thread thread : threads){
            System.out.println(thread.getName() + " " + thread.getState());
        }
    }
}
