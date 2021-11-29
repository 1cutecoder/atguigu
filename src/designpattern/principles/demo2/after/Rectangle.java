package designpattern.principles.demo2.after;

/**
 * @author zcl
 * @date 2021/11/29 15:58
 */
public class Rectangle implements Quadrilateral {
    private double length;
    private double width;

    public void setLength(double length) {
        this.length = length;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    @Override
    public double getLength() {
        return length;
    }

    @Override
    public double getWidth() {
        return width;
    }
}
