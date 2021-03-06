package designpattern.observer.weatherstation;

import java.util.Observable;

/**
 * 类描述
 *
 * @author zcl
 * @Description TODO
 * @Date 2022/6/24 10:15
 */
public class WeatherData extends Observable {
    private double temperature;
    private double humidity;
    private double pressure;

    public WeatherData() {
    }

    /**向观察者发送数据*/
    public void measurementsChanged() {
        //向观察者发送数据之前必须先调用这个
        setChanged();
        //个人认为notifyOberservers()会自动调用观察者的 update()方法
        notifyObservers();
    }

    /**从数据源收到数据后，是先更新自己的数据，再把数据发给观察者*/
    public void setMeasurements(double temp, double humidity, double pressure) {
        this.temperature = temp;
        this.humidity = humidity;
        this.pressure = pressure;
        measurementsChanged();
    }

    /**留出接口给观察者获取数据*/
    public double getTemperature() {
        return temperature;
    }


    public double getHumidity() {
        return humidity;
    }


    public double getPressure() {
        return pressure;
    }
}
