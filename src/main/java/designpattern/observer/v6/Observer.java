package designpattern.observer.v6;

/**
 * 类描述
 *
 * @author zcl
 * @Description TODO
 * @Date 2022/6/24 9:15
 */
public interface Observer {
    void actionOnWakeup(WakeupEvent wakeupEvent);
}