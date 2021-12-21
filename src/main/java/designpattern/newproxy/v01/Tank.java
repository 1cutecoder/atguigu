package designpattern.newproxy.v01;

import org.aspectj.lang.annotation.AdviceName;
import org.aspectj.lang.annotation.Aspect;

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
        new Tank().move();
    }
}
