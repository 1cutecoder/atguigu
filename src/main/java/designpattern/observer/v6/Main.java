package designpattern.observer.v6;

import java.util.ArrayList;
import java.util.List;

/**
 * 类描述
 *
 * @author zcl
 * @Description TODO
 * @Date 2021/12/20 21:28
 */
class Child {

    private boolean cry = false;
    private List<Observer> observers = new ArrayList<>();

    {
        observers.add(new Dad());
        observers.add(new Mom());
        observers.add(new Dog());
    }

    public void wakeup() {
        cry = true;
        for (Observer observer : observers) {
            observer.actionOnWakeup(new WakeupEvent(System.currentTimeMillis(),"bed",this));
        }
    }
}
class WakeupEvent{
    long timeStamp;
    String loc;
    Child source;

    public WakeupEvent(long timeStamp, String loc, Child source) {
        this.timeStamp = timeStamp;
        this.loc = loc;
        this.source = source;
    }
}

interface Observer {
    void actionOnWakeup(WakeupEvent wakeupEvent);
}

class Dad implements Observer {
    public void feed() {
        System.out.println("dad feeding ..........");
    }

    @Override
    public void actionOnWakeup(WakeupEvent wakeupEvent) {
        feed();
    }
}

class Mom implements Observer {
    public void feed() {
        System.out.println("Mom feeding ..........");
    }

    @Override
    public void actionOnWakeup(WakeupEvent wakeupEvent) {
        feed();
    }
}

class Dog implements Observer {
    public void feed() {
        System.out.println("Dog barking ..........");
    }

    @Override
    public void actionOnWakeup(WakeupEvent wakeupEvent) {
        feed();
    }
}

/**
 * @author zcl
 */
public class Main {
    public static void main(String[] args) {
        Child child = new Child();
        child.wakeup();
    }
}
