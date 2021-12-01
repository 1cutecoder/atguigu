package designpattern.principles.OpenClosed.before;

/**
 * @author zcl
 * @date 2021/11/29 15:35
 */
public class Square extends Rectangle{
    @Override
    public void setWidth(double width) {
        super.setWidth(width);
        super.setLength(width);
    }
}
