package inheritablethreadlocalobject;

/**
 * 重写 childValue 方法实现对继承的值进行加工
 */
public class InheritableThreadLocalChildValueThread implements Runnable {

    private InheritableThreadLocalExtDemo inheritableThreadLocalExtDemo;
    
    private String str = "abc";
    
    public InheritableThreadLocalChildValueThread(InheritableThreadLocalExtDemo inheritableThreadLocalExtDemo) {
        this.inheritableThreadLocalExtDemo = inheritableThreadLocalExtDemo;
    }

    @Override
    public void run() {
        try{
            for(int i=0; i<10; i++){
                System.out.println("在线程 InheritableThreadLocalChildValueThread 中取值=" + inheritableThreadLocalExtDemo.get());
                Thread.sleep(100);
                // 线程设置值
                inheritableThreadLocalExtDemo.set("abc" + i);
            }
        }catch (InterruptedException e){
            // doNothing
        }
    }
}
