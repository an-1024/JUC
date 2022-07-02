package waitnotifyconsumerproducermult;

public class SetProducerCheckBoxStatusThread implements Runnable {

    private BoxProducerService boxProducerService;

    public SetProducerCheckBoxStatusThread(BoxProducerService boxProducerService) {
        this.boxProducerService = boxProducerService;
    }

    @Override
    public void run() {
        boxProducerService.checkBoxStatus();
    }
}
