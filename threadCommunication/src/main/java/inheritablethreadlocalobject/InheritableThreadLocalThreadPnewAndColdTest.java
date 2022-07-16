package inheritablethreadlocalobject;

/**
 * 父线程拥有新值，子线程仍是旧值
 */
public class InheritableThreadLocalThreadPnewAndColdTest {
    public static void main(String[] args) {
        try{
            for(int i=0; i<10; i++){
                if(InheritableThreadLocalDemo.inheritableThreadLocal.get() == null){
                    InheritableThreadLocalDemo.inheritableThreadLocal.set("此值是 main 线程 放入的!");
                }
                System.out.println("           在 main 线程中取值=" + InheritableThreadLocalDemo.inheritableThreadLocal.get());
                Thread.sleep(100);
            }
            InheritableThreadLocalThread threadLocalThread = new InheritableThreadLocalThread();
            Thread t1 = new Thread(threadLocalThread);
            t1.start();
            Thread.sleep(300);
            InheritableThreadLocalDemo.inheritableThreadLocal.set("此值是 main 线程 new 放入的");
            System.out.println("               在 main 线程中取值=" + InheritableThreadLocalDemo.inheritableThreadLocal.get());
            
            
        }catch (InterruptedException e){
            // doNothing
        }
    }
}
