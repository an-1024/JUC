package waitnotifycounsumerproducerthread;

public class ProducerThread_1 implements Runnable {

    private MyStack_1 myStack_1;

    public ProducerThread_1(MyStack_1 myStack_1){
        this.myStack_1 = myStack_1;
    }

    @Override
    public void run() {
        while (true) {
            myStack_1.pushStack();
        }
    }
}
