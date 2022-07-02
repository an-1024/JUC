package waitnotifyconsumerproducermult;

public class BoxProducerThread implements Runnable{

    private BoxProducerService boxProducerService;

    public BoxProducerThread(BoxProducerService boxProducerService) {
        this.boxProducerService = boxProducerService;
    }

    @Override
    public void run() {
        while (true) {
            boxProducerService.setBoxMethod();
        }
    }
}
