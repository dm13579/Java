package proxy.cglibproxy;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @author Administrator
 * @version V1.0
 * @ClassName:CglibProxy
 * @Description:Cglib 代理
 * @date 2019/12/11
 */
public class CglibProxy implements MethodInterceptor{

    private Object target;//维护一个目标对象
    public CglibProxy(Object target) {
        this.target = target;
    }

    //为目标对象生成代理对象
    public Object getProxyInstance() {
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(target.getClass());
        enhancer.setCallback(this);
        return enhancer.create();
    }

    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.out.println("开启事务");

        Object returnvalue = method.invoke(target, objects);

        System.out.println("关闭事务");

        return null;
    }
}
