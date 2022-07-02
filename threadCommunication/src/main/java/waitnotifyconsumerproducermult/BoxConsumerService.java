package waitnotifyconsumerproducermult;

public class BoxConsumerService {
    private BoxMethod boxMethod;

    public BoxConsumerService(BoxMethod boxMethod) {
        this.boxMethod = boxMethod;
    }

    public void getMethod(){
        synchronized(this){
            while (boxMethod.size() == 0){
                try {
                    System.out.println("BoxConsumerService 所有箱子拆解完成。等待重新生产" + boxMethod.size());
                    this.wait();
                } catch (InterruptedException e) {
                    // doNothing
                }
            }
            boxMethod.popFirst();
            System.out.println(Thread.currentThread().getName() + " 线程开始拆解第【" + boxMethod.size() + "】个箱子");
            try {
                Thread.sleep(300);
            } catch (InterruptedException e) {
                // doNothing
            }
        }
    }


    public void checkBoxStatus(){
        while (true){
            synchronized (this){
                if(boxMethod.size() > 0){
                    this.notifyAll();
                }
            }
            System.out.println(Thread.currentThread().getName() + " get checkBoxStatus= " + boxMethod.size());
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                // doNothing
            }
        }
    }
}
