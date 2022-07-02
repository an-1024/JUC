package waitnotifycounsumerproducerthreadoperatestack;

import java.util.ArrayList;
import java.util.List;

public class MyStack_2 {
    private List<String> stackList = new ArrayList<String>();

    synchronized public void pushStack() {
        while (stackList.size() == 1) {
            try {
                this.wait();
            } catch (InterruptedException e) {
                // doNothing
            }
        }
        stackList.add("anyString= " + Math.random());
        this.notify();
        System.out.println(Thread.currentThread().getName() + " push= " + stackList.size());
    }

    synchronized public void popStack() {
        while (stackList.size() == 0) {
            System.out.println(Thread.currentThread().getName() + " pop 操作中的 " + Thread.currentThread().getName() + " 线程状态处于 wait 状态 ！！！");
            try {
                this.wait();
            } catch (InterruptedException e) {
                // doNothing
            }
        }
        stackList.remove(0);
        this.notify();
        System.out.println(Thread.currentThread().getName() + " pop= " + stackList.size());
    }
}