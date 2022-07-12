package inheritablethreadlocalobject;

public class InheritableThreadLocalThreadTest {
    public static void main(String[] args) {
        try{
            for(int i=0; i<10; i++){
                if(InheritableThreadLocalDemo.inheritableThreadLocal.get() == null){
                    InheritableThreadLocalDemo.inheritableThreadLocal.set("此值是 main 线程 放入的!");
                }
                System.out.println("           在 main 线程中取值=" + InheritableThreadLocalDemo.inheritableThreadLocal.get());
                Thread.sleep(100);
            }
            Thread.sleep(5000);
            InheritableThreadLocalThread threadLocalThread = new InheritableThreadLocalThread();
            Thread t1 = new Thread(threadLocalThread);
            t1.start();
        }catch (InterruptedException e){
            // doNothing
        }
    }
}
