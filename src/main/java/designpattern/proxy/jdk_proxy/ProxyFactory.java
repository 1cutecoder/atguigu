package designpattern.proxy.jdk_proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author zcl
 * @date 2021/12/10 14:53
 */
public class ProxyFactory {
    private TrainStation trainStation = new TrainStation();

    public SellTickets getProxyObject() {
        //���ش�����󼴿�
        SellTickets proxyInstance = (SellTickets) Proxy.newProxyInstance(
                trainStation.getClass().getClassLoader(),
                trainStation.getClass().getInterfaces(),
                new InvocationHandler() {
                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        System.out.println("������յ�����start");
                        method.invoke(trainStation, args);
                        System.out.println("������յ�����end");
                        return null;
                    }
                });
        return proxyInstance;
    }
}
