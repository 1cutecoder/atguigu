package designpattern.builder.before;

/**
 * @author zcl
 * @date 2021/12/9 10:19
 */
public class Bike {
    private String frame;

    private String seat;

    public void setFrame(String frame) {
        this.frame = frame;
    }

    public void setSeat(String seat) {
        this.seat = seat;
    }

    public String getFrame() {
        return frame;
    }

    public String getSeat() {
        return seat;
    }
}
