package waitnotifycounsumerproducerthreadoperatestack;

public class ConsumerThread_2 implements Runnable {

    private MyStack_2 myStack_2;

    public ConsumerThread_2(){}

    public ConsumerThread_2(MyStack_2 myStack_2){
        this.myStack_2 = myStack_2;
    }

    public void run() {
        while (true) {
            myStack_2.popStack();
        }
    }
}
