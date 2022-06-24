package designpattern.observer.v6;

/**
 * 类描述
 *
 * @author zcl
 * @Description TODO
 * @Date 2022/6/24 9:18
 */
public class Mom implements Observer {
    public void feed() {
        System.out.println("Mom feeding ..........");
    }

    @Override
    public void actionOnWakeup(WakeupEvent wakeupEvent) {
        feed();
    }
}