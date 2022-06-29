package waitandnotifythread;

public class WaitThreadDemo_2 {
    public static void main(String[] args) {
        String lock = new String("");
        System.out.println("未获取 String 对象的 monitor 对象");
        synchronized(lock){
        try {
            System.out.println("获取到 String monitor 对象, 执行 wait 方法");
            lock.wait();
            System.out.println("执行 wait 方法后，是否能打印此行日志");
            } catch(InterruptedException e){
                // doNothing
            }
        }
    }
}
