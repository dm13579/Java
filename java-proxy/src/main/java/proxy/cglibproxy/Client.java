package proxy.cglibproxy;


/**
 * @author Administrator
 * @version V1.0
 * @ClassName:client
 * @Description:cglib代理
 * @date 2019/12/10
 */
public class Client {
    public static void main(String[] args) {
        RealSubject realSubject = new RealSubject();
        System.out.println(realSubject.getClass());

        RealSubject proxy = (RealSubject) new CglibProxy(realSubject).getProxyInstance();
        System.out.println(proxy.getClass());
        proxy.request();
    }
}
