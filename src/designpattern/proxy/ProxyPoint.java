package designpattern.proxy;

/**
 * @author zcl
 * @date 2021/12/10 14:23
 */
public class ProxyPoint implements SellTickets{
    private TrainStation trainStation = new TrainStation();
    /**
     * ����Ʊ
     */
    @Override
    public void sell() {
        System.out.println("============���յ�start===================");
        trainStation.sell();
        System.out.println("============���յ�end=================");
    }
}
