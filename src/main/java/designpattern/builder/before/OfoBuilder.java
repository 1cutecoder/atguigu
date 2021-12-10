package designpattern.builder.before;

/**
 * @author zcl
 * @date 2021/12/9 10:32
 */
public class OfoBuilder extends Builder {
    /**
     * ����
     */
    @Override
    public void buildFrame() {
        bike.setFrame("���Ͻ𳵼�");
    }

    /**
     * ����
     */
    @Override
    public void buildSeat() {
        bike.setSeat("�𽺳���");
    }

    /**
     * �������г��ķ���
     *
     * @return
     */
    @Override
    public Bike createBike() {
        return bike;
    }
}
