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
    public TrainStation getProxyObject(){
        //创建Enhancer对象，类似于JDK动态代理的Proxy类
        Enhancer enhancer = new Enhancer();
        //设置父类的字节码对象
        enhancer.setSuperclass(TrainStation.class);
        //设置回调函数
        enhancer.setCallback(this);
        //创建代理对象
        TrainStation proxyObject = (TrainStation) enhancer.create();
        return proxyObject;
    }

    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.out.println("代理点收取一点手续费start");
        method.invoke(trainStation,objects);
        System.out.println("代理点收取一点手续费end");

        return null;
    }
}
