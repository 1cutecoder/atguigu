package designpattern.proxy.jdk_proxy;

/**
 * @author zcl
 * @date 2021/12/10 14:23
 */
public class TrainStation implements SellTickets {

    /**
     * ����Ʊ
     */
    @Override
    public void sell() {
        System.out.println("��վ��Ʊ");
    }
}
