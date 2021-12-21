package designpattern.newproxy.v07;

import java.time.LocalDateTime;

/**
 * @author zcl
 * @date 2021/12/21 16:20
 */
public class TankTimeProxy implements Movable {
    Movable m;

    public TankTimeProxy(Movable m) {
        this.m = m;
    }

    @Override
    public void move() {
        System.out.println(LocalDateTime.now());
        m.move();
    }
}
