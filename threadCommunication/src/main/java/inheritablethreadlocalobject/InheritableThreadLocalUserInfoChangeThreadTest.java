package inheritablethreadlocalobject;

/**
 * 子线程感受对象属性值的变化
 */
public class InheritableThreadLocalUserInfoChangeThreadTest {
    public static void main(String[] args) {
        UserInfo userInfo = new UserInfo();
        System.out.println("InheritableThreadLocalUserInfoChangeThread userInfo " + userInfo.hashCode());
        userInfo.setUserName("中国");
        if (InheritableThreadLocalDemo.inheritableThreadLocalUserInfo.get() == null){
            InheritableThreadLocalDemo.inheritableThreadLocalUserInfo.set(userInfo);
        }
        System.out.println("                    在 main 线程中取值= " + InheritableThreadLocalDemo.inheritableThreadLocalUserInfo.get().getUserName() + " " + InheritableThreadLocalDemo.inheritableThreadLocalUserInfo.hashCode());
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            // doNothing
        }
        InheritableThreadLocalUserInfoChangeThread userInfoChangeThread = new InheritableThreadLocalUserInfoChangeThread();
        Thread t1 = new Thread(userInfoChangeThread);
        t1.start();

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            // doNothing
        }
        
        InheritableThreadLocalDemo.inheritableThreadLocalUserInfo.get().setUserName("China");
    }
}
