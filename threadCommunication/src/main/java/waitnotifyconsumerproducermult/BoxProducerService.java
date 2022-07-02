package waitnotifyconsumerproducermult;

public class BoxProducerService {
    private BoxMethod boxMethod;

    public BoxProducerService(BoxMethod boxMethod){
        this.boxMethod = boxMethod;
    }

    public void setBoxMethod(){
        synchronized (this){
            while(boxMethod.size() == 50){
                try {
                    System.out.println("BoxProducerService 箱子生产达到上线，需要等待拆解" + boxMethod.size());
                    this.wait();
                } catch (InterruptedException e) {
                    // doNothing
                }
            }
            try {
                Thread.sleep(300);
                boxMethod.add();
            } catch (InterruptedException e) {
                // doNothing
            }
        }
    }

    public void checkBoxStatus(){
        while(true){
            synchronized (this){
                if(boxMethod.size() < 50){
                    this.notifyAll();
                }
            }
            System.out.println("set checkBoxStatus= " + boxMethod.size());
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                // doNothing
            }
        }
    }

}
