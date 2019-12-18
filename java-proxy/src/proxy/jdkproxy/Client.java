package proxy.jdkproxy;

/**
 * @author Administrator
 * @version V1.0
 * @ClassName:client
 * @Description:动态代理
 * @date 2019/12/10
 */
public class Client {
    public static void main(String[] args) {
        RealSubject realSubject = new RealSubject();
        System.out.println(realSubject.getClass());
        // 在这里只可以转型为Subject,如果转型为RealSubject会报ClassCastException
        // 这一现象只能以动态代理只能对接口进行代理，不能对类进行代理
        Subject proxy = (Subject) new JdkProxy(realSubject).getProxyInstance();
        System.out.println(proxy.getClass());
        proxy.request();
    }
}
