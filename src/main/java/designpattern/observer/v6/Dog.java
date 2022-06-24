package designpattern.observer.v6;

/**
 * 类描述
 *
 * @author zcl
 * @Description TODO
 * @Date 2022/6/24 9:18
 */
public class Dog implements Observer {
    public void feed() {
        System.out.println("Dog barking ..........");
    }

    @Override
    public void actionOnWakeup(WakeupEvent wakeupEvent) {
        feed();
    }
}
