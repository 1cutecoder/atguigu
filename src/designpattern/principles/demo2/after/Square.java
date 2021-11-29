package designpattern.principles.demo2.after;

/**
 * @author zcl
 * @date 2021/11/29 15:57
 */
public class Square implements Quadrilateral{
    private double side;

    public void setSide(double side) {
        this.side = side;
    }

    public double getSide() {
        return side;
    }

    @Override
    public double getLength() {
        return side;
    }

    @Override
    public double getWidth() {
        return side;
    }
}
