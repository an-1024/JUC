package waitnotifycounsumerproducerthread;

public class ConsumerThread_1 implements Runnable {

    private MyStack_1 myStack_1;

    public ConsumerThread_1(){}

    public ConsumerThread_1(MyStack_1 myStack_1){
        this.myStack_1 = myStack_1;
    }

    public void run() {
        while (true) {
            myStack_1.popStack();
        }
    }
}
