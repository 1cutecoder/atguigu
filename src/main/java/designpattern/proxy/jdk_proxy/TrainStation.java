package designpattern.proxy.jdk_proxy;

/**
 * @author zcl
 * @date 2021/12/10 14:23
 */
public class TrainStation implements SellTickets {

    /**
     * Âô»ğ³µÆ±
     */
    @Override
    public void sell() {
        System.out.println("»ğ³µÕ¾ÂôÆ±");
    }
}
