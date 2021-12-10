package designpattern.proxy.static_proxy;

/**
 * @author zcl
 * @date 2021/12/10 14:29
 */
public class Client {
    public static void main(String[] args) {
        ProxyPoint proxyPoint = new ProxyPoint();
        proxyPoint.sell();
    }
}
