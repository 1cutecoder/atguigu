package designpattern.proxy.jdk_proxy;

/**
 * @author zcl
 * @date 2021/12/10 15:04
 */
public class Client {
    public static void main(String[] args) {
        ProxyFactory proxyFactory = new ProxyFactory();
        SellTickets proxyObject = proxyFactory.getProxyObject();
        proxyObject.sell();
    }
}
