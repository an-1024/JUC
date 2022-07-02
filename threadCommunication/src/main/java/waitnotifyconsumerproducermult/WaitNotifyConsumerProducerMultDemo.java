package waitnotifyconsumerproducermult;

public class WaitNotifyConsumerProducerMultDemo {
    public static void main(String[] args) {
        BoxMethod boxMethod = new BoxMethod();
        BoxProducerService boxProducerService = new BoxProducerService(boxMethod);
        for (int i = 0; i < 2; i++) {
            BoxProducerThread boxProducerThread = new BoxProducerThread(boxProducerService);
            Thread p_Thread = new Thread(boxProducerThread);
            p_Thread.setName("p_Thread_" + i);
            p_Thread.start();
        }


        try {
            Thread.sleep(50);
        } catch (InterruptedException e) {
            // doNothing
        }

        SetProducerCheckBoxStatusThread producerCheckBoxStatusThread = new SetProducerCheckBoxStatusThread(boxProducerService);
        Thread p_s_Thread = new Thread(producerCheckBoxStatusThread);
        p_s_Thread.setName("p_s_Thread");
        p_s_Thread.start();

        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            // doNothing
        }

        BoxConsumerService boxConsumerService = new BoxConsumerService(boxMethod);
        for (int i = 0; i < 10; i++) {
            BoxConsumerThread boxConsumerThread = new BoxConsumerThread(boxConsumerService);
            Thread c_Thread = new Thread(boxConsumerThread);
            c_Thread.setName("c_Thread_" + i);
            c_Thread.start();
        }
        try {
            Thread.sleep(50);
        } catch (InterruptedException e) {
            // doNothing
        }

        SetConsumerCheckBoxStatusThread consumerCheckBoxStatusThread = new SetConsumerCheckBoxStatusThread(boxConsumerService);
        Thread c_s_Thread = new Thread(consumerCheckBoxStatusThread);
        c_s_Thread.setName("c_s_Thread");
        c_s_Thread.start();
    }
}
