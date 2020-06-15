package proxy.jdkproxy;

/**
 * @author Administrator
 * @version V1.0
 * @ClassName:RealSubject
 * @Description:真实主题
 * @date 2019/12/11
 */
public class RealSubject implements Subject {

    @Override
    public void request() {
        System.out.println("访问真实主题方法...");
    }
}
