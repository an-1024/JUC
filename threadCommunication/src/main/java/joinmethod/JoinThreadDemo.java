package joinmethod;

public class JoinThreadDemo {
    public static void main(String[] args) {
        JoinMethodThread joinMethodThread = new JoinMethodThread();
        Thread j_Thread = new Thread(joinMethodThread);
        j_Thread.start();
        try {
            j_Thread.join();
        } catch (InterruptedException e) {
            // doNothing
        }

        System.out.println(Thread.currentThread().getName() + " 等待线程" + j_Thread.getName() + "执行完成");
    }
}
