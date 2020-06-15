package proxy.jdkproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author Administrator
 * @version V1.0
 * @ClassName:Proxy
 * @Description:动态代理
 * @date 2019/12/11
 */
public class JdkProxy {

    private Object target;// 维护一个目标对象

    public JdkProxy(Object target) {
        this.target = target;
    }

    public Object getProxyInstance(){

        // 第一个参数：指定当前目标对象使用类加载器
        // 第二个参数：目标对象实现的接口的类型
        // 第三个参数：事件处理器
        return Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(), new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                System.out.println("开启事务");

                Object returnValue = method.invoke(target,args);

                System.out.println("提交事务");
                return null;
            }
        });
    }
}
