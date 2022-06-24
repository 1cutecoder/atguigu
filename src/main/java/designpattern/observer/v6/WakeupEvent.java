package designpattern.observer.v6;

/**
 * 类描述
 *
 * @author zcl
 * @Description TODO
 * @Date 2022/6/24 9:21
 */
public class WakeupEvent {
    long timeStamp;
    String loc;
    Child source;

    public WakeupEvent(long timeStamp, String loc, Child source) {
        this.timeStamp = timeStamp;
        this.loc = loc;
        this.source = source;
    }
}