package waitnotifyconsumerproducermult;

public class SetConsumerCheckBoxStatusThread implements Runnable {

    BoxConsumerService consumerService;

    public SetConsumerCheckBoxStatusThread(BoxConsumerService consumerService) {
        this.consumerService = consumerService;
    }

    @Override
    public void run() {
        consumerService.checkBoxStatus();
    }
}
