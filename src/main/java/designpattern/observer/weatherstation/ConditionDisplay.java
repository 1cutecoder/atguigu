package designpattern.observer.weatherstation;

import java.util.Observable;
import java.util.Observer;

/**
 * 类描述
 *
 * @author zcl
 * @Description TODO
 * @Date 2022/6/24 9:39
 */
public class ConditionDisplay implements Observer, DisplayElement {
    private String name;
    /**
     * 观察者也要维护一个中介(WeatherData)作为数据源
     */
    private Observable observable;

    /**
     * 当观察者初始化时，需要指定数据源和观察者的名字
     */
    public ConditionDisplay(Observable observable, String name) {
        this.name = name;
        this.observable = observable;
        //向数据源注册，代表需要从数据源获取数据
        observable.addObserver(this);
    }

    @Override
    public void display(Observable o) {
        if (o instanceof WeatherData) {
            WeatherData weatherData = (WeatherData) o;
            System.out.println("观察者" + name + "的数据:");
            System.out.println("temperature:" + weatherData.getTemperature());
            System.out.println("humidity:" + weatherData.getHumidity());
            System.out.println("pressure:" + weatherData.getPressure());
            System.out.println();
        }
    }

    @Override
    public void update(Observable o, Object arg) {
        if (o instanceof WeatherData) {
            display(o);
        }
    }
}
