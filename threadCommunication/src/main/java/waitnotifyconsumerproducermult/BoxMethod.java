package waitnotifyconsumerproducermult;

import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class BoxMethod {
    private static List<String> boxList = new LinkedList<String>();
    AtomicInteger atomicInteger = new AtomicInteger();

    synchronized public void add(){
        if(boxList.size() < 50){
            System.out.println(Thread.currentThread().getName() + " 线程正在生产第 【 " + size() + "】箱子");
            boxList.add("box_" + atomicInteger.incrementAndGet());
        }
    }

    synchronized public int size(){
        return boxList.size();
    }

    synchronized public Object  popFirst(){
        System.out.println(Thread.currentThread().getName() + " 将要移除分解的箱子为: " + boxList.get(0));
        Object value = boxList.remove(0);
        System.out.println(Thread.currentThread().getName() + " 执行 popFirst() 方法, size 大小为: " + size());
        return value;
    }
}
