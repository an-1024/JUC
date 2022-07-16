package inheritablethreadlocalobject;

import java.util.Date;

/**
 * 重写 childValue 方法实现对继承的值进行加工
 */
public class InheritableThreadLocalExtDemo extends InheritableThreadLocal {
    @Override
    protected Object initialValue() {
        return new Date().getTime();
    }

    @Override
    protected Object childValue(Object parentValue) {
        return parentValue + " 我在子线程加的!";
    }
}
