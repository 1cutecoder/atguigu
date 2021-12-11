package designpattern.proxy.static_proxy;

import designpattern.proxy.jdk_proxy.SellTickets;
import designpattern.proxy.jdk_proxy.TrainStation;

/**
 * @author zcl
 * @date 2021/12/10 14:23
 */
public class ProxyPoint implements SellTickets {
    private TrainStation trainStation = new TrainStation();
    /**
     * 卖火车票
     */
    @Override
    public void sell() {
        System.out.println("============代收点start===================");
        trainStation.sell();
        System.out.println("============代收点end=================");
    }
}
