package designpattern.newproxy.v08;

import designpattern.newproxy.v07.TankLogProxy;
import designpattern.newproxy.v07.TankTimeProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Random;

/**
 * @author zcl
 * @date 2021/12/21 16:25
 */
public class Tank implements Movable {
    @Override
    public void move() {
        System.out.println("Tank moving claclacla...");
        try {
            Thread.sleep(new Random().nextInt(10000));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Tank tank = new Tank();
        System.out.println("1=================");
//        System.getProperties().put("jdk.proxy.ProxyGenerator.saveGeneratedFiles", "true");
        //reflection ͨ���������ֽ������������Ժͷ���
        Movable m = (Movable) Proxy.newProxyInstance(Tank.class.getClassLoader(), new Class[]{Movable.class}, new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                System.out.println("method " + method.getName() + " start ...");
                Object o = method.invoke(tank, args);
                System.out.println("method " + method.getName() + " end ...");
                return o;
            }
        });
        m.move();
        System.out.println("2=================");
        Movable m1 = (Movable) Proxy.newProxyInstance(Tank.class.getClassLoader(), new Class[]{Movable.class}, new LogHandler(tank));
        m1.move();

    }
}

class LogHandler implements InvocationHandler {
    Tank tank;

    public LogHandler(Tank tank) {
        this.tank = tank;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("method " + method.getName() + "start ...");
        method.invoke(tank, args);
        System.out.println("method " + method.getName() + "end ...");
        return null;
    }
}

