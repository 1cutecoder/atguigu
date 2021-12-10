package designpattern.abstract_factory_and_builder;

/**
 * @author zcl
 * @date 2021/12/9 15:28
 */
public class HonDaWheel extends Wheel{
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

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("HonDaWheel{");
        sb.append("color='").append(color).append('\'');
        sb.append(", radium=").append(radium);
        sb.append('}');
        return sb.toString();
    }
}
