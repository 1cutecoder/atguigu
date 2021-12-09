package designpattern.abstract_factory_and_builder;

/**
 * @author zcl
 * @date 2021/12/9 15:28
 */
public class Wheel {
    private String color;
    private double radium;

    public void setColor(String color) {
        this.color = color;
    }

    public void setRadium(double radium) {
        this.radium = radium;
    }

    public String getColor() {
        return color;
    }

    public double getRadium() {
        return radium;
    }
}
