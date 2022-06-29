package waitandnotifythread;

public class WaitThreadDemo_1 {
    public static void main(String[] args) {
        String newString = new String("");

        try {
            newString.wait();
        } catch (InterruptedException e) {
            // doNothing
        }
    }
}
