package designpattern.observer.v6;

import java.util.ArrayList;
import java.util.List;

/**
 * 类描述
 *
 * @author zcl
 * @Description TODO
 * @Date 2022/6/24 9:15
 */
public class Child {

    private boolean cry = false;
    private List<Observer> observers = new ArrayList<>();

    {
        observers.add(new Dad());
        observers.add(new Mom());
        observers.add(new Dog());
        observers.add((wakeupEvent) -> System.out.println("ppp"));
    }

    public void wakeup() {
        cry = true;
        for (Observer observer : observers) {
            observer.actionOnWakeup(new WakeupEvent(System.currentTimeMillis(), "bed", this));
        }
    }
}
