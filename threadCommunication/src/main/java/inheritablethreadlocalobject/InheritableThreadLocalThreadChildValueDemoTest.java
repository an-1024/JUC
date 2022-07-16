package inheritablethreadlocalobject;

/**
 * 重写 childValue 方法实现对继承的值进行加工
 */
public class InheritableThreadLocalThreadChildValueDemoTest {
    public static void main(String[] args) {
        try{
            InheritableThreadLocalExtDemo threadLocalExtDemo = new InheritableThreadLocalExtDemo();
            threadLocalExtDemo.initialValue();
            for(int i=0; i<10; i++){
                System.out.println("           在 main 线程中取值=" + threadLocalExtDemo.get());
                Thread.sleep(100);
            }
            InheritableThreadLocalChildValueThread threadLocalThread = new InheritableThreadLocalChildValueThread(threadLocalExtDemo);
            Thread t1 = new Thread(threadLocalThread);
            t1.start();
            System.out.println("               在 main 线程中取值=" + threadLocalExtDemo.get());
            Thread.sleep(300);
        }catch (InterruptedException e){
            // doNothing
        }
    }
}
