package inheritablethreadlocalobject;

/**
 * 子线程感受对象属性值的变化
 */
public class InheritableThreadLocalUserInfoChangeThread implements Runnable{
    @Override
    public void run() {
        try{
            for (int i=0; i<10; i++) {
                UserInfo userInfo = InheritableThreadLocalDemo.inheritableThreadLocalUserInfo.get();
                System.out.println("在 InheritableThreadLocalUserInfoChangeThread 线程中取值" + userInfo.getUserName() + " " + userInfo.hashCode());
                Thread.sleep(1000);
            }
        }catch (Exception e){
            // doNothing
        }
    }
}
