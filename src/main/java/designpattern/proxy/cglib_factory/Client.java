package designpattern.proxy.cglib_factory;

/**
 * @author zcl
 * @date 2021/12/10 16:55
 */
public class Client {
    public static void main(String[] args) {
        ProxyFactory proxyFactory = new ProxyFactory();
        TrainStation proxyObject = proxyFactory.getProxyObject();
        proxyObject.sell();
    }
}
