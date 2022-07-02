package waitnotifycounsumerproducerthread;

public class ProducerThread_2 implements Runnable {

    private MyStack_2 myStack_2;

    public ProducerThread_2(MyStack_2 myStack_2){
        this.myStack_2 = myStack_2;
    }

    @Override
    public void run() {
        while (true) {
            myStack_2.pushStack();
        }
    }
}
