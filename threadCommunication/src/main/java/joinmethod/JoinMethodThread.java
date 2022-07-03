package joinmethod;

public class JoinMethodThread implements Runnable {

    @Override
    public void run() {
        int secondValue = (int) (Math.random() * 10000);
        System.out.println(secondValue);
        try {
            Thread.sleep(secondValue);
            Thread.sleep(100000);
            System.out.println(Thread.currentThread().getName() + " 线程休眠完成继续运行" );
        } catch (InterruptedException e) {
            // doNothing
        }
    }
}
