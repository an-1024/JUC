package inheritablethreadlocalobject;

public class InheritableThreadLocalDemo {
    public static InheritableThreadLocal inheritableThreadLocal = new InheritableThreadLocal();
    public static InheritableThreadLocal<UserInfo> inheritableThreadLocalUserInfo = new InheritableThreadLocal<>();
}
