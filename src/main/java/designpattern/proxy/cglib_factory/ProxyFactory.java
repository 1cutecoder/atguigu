package designpattern.proxy.cglib_factory;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @author zcl
 * @date 2021/12/10 16:17
 */
public class ProxyFactory implements MethodInterceptor {
    private TrainStation trainStation = new TrainStation();

    public TrainStation getProxyObject() {
        //����Enhancer����������JDK��̬�����Proxy��
        Enhancer enhancer = new Enhancer();
        //���ø�����ֽ������
        enhancer.setSuperclass(TrainStation.class);
        //���ûص�����
        enhancer.setCallback(this);
        //�����������
        TrainStation proxyObject = (TrainStation) enhancer.create();
        return proxyObject;
    }

    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.out.println("�������ȡһ��������start");
        method.invoke(trainStation, objects);
        System.out.println("�������ȡһ��������end");

        return null;
    }
}
