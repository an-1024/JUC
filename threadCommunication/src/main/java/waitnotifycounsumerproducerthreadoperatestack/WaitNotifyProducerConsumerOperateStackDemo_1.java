package waitnotifycounsumerproducerthreadoperatestack;

public class WaitNotifyProducerConsumerOperateStackDemo_1 {
    public static void main(String[] args) {
        MyStack_1 myStack_1 = new MyStack_1();

        ConsumerThread_1 consumerThread_1 = new ConsumerThread_1(myStack_1);
        ProducerThread_1 producerThread_1 = new ProducerThread_1(myStack_1);

        Thread c_Thread = new Thread(consumerThread_1);
        Thread p_Thread = new Thread(producerThread_1);

        c_Thread.setName("c_Thread");
        p_Thread.setName("p_Thread");

        p_Thread.start();
        c_Thread.start();
    }
}
