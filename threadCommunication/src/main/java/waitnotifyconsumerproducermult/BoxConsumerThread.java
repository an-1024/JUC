package waitnotifyconsumerproducermult;

public class BoxConsumerThread implements Runnable {

    private BoxConsumerService consumerService;

    public BoxConsumerThread(BoxConsumerService consumerService) {
        this.consumerService = consumerService;
    }

    @Override
    public void run() {
        while(true){
            consumerService.getMethod();
        }
    }
}
