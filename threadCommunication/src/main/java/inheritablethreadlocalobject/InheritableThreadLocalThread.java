package inheritablethreadlocalobject;

public class InheritableThreadLocalThread implements Runnable {
    @Override
    public void run() {
        try{
            for(int i=0; i<10; i++){
                System.out.println("在线程 InheritableThreadLocalThread 中取值=" + InheritableThreadLocalDemo.inheritableThreadLocal.get());
                Thread.sleep(100);
            }
        }catch (InterruptedException e){
            // doNothing
        }
    }
}
