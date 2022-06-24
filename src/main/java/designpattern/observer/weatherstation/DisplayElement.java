package designpattern.observer.weatherstation;

import java.util.Observable;

/**
 * 类描述
 *
 * @author zcl
 * @Description TODO
 * @Date 2022/6/24 8:54
 */
public interface DisplayElement {
    /**
     * 用于显示报告板的数据
     */
    public void display(Observable observable);


}
