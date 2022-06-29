package waitandnotifythread;

public class WaitNotifyDemo {

    private static Object lock = new Object();

    public static void main(String[] args) {
        Thread t1 = new Thread(new Runnable() {
            public void run() {
                synchronized (lock){
                    System.out.println("T1 start wait time = " + System.currentTimeMillis());
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        // doNothing
                    }
                    System.out.println("T1 end wait time = " + System.currentTimeMillis());
                }
            }
        }, "T1");

        Thread t2 = new Thread(new Runnable() {
            public void run() {
                synchronized (lock){
                    lock.notify();
                    System.out.println("T2 weak up T1 time = " + System.currentTimeMillis());
                }
            }
        }, "T2");

        t1.start();

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            // doNothing
        }

        t2.start();
    }
}
