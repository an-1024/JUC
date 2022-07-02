package waitnotifycounsumerproducerthreadoperatestack;

import java.util.ArrayList;
import java.util.List;

public class MyStack_1 {
    private List<String> stackList = new ArrayList<String>();

    synchronized public void pushStack() {
        if (stackList.size() == 1) {
            try {
                this.wait();
            } catch (InterruptedException e) {
                // doNothing
            }
        }
        stackList.add("anyString= " + Math.random());
        this.notify();
        System.out.println("push= " + stackList.size());
    }

    synchronized public void popStack() {
        if (stackList.size() == 0) {
            System.out.println("pop 操作中的 " + Thread.currentThread().getName() + " 线程状态处于 wait 状态 ！！！");
            try {
                this.wait();
            } catch (InterruptedException e) {
                // doNothing
            }
        }
        stackList.remove(0);
        this.notify();
        System.out.println("pop= " + stackList.size());
    }
}