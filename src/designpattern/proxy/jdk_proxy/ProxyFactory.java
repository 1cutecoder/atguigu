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
        //返回代理对象即可
        SellTickets proxyInstance = (SellTickets) Proxy.newProxyInstance(trainStation.getClass().getClassLoader(), trainStation.getClass().getInterfaces(), new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                System.out.println("代理点收点服务费start");
                method.invoke(trainStation,args);
                System.out.println("代理点收点服务费end");
                return null;
            }
        });
        return proxyInstance;
    }
}
