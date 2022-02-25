package designpattern.newproxy.v07;

/**
 * @author zcl
 * @date 2021/12/21 16:47
 */
public class TankLogProxy implements Movable {
    Movable m;

    public TankLogProxy(Movable m) {
        this.m = m;
    }

    @Override

    public void move() {
        System.out.println("start moving...");
        m.move();
    }
}
