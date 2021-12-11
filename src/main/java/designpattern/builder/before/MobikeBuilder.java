package designpattern.builder.before;

/**
 * @author zcl
 * @date 2021/12/9 10:32
 */
public class MobikeBuilder extends Builder {
    /**
     * ����
     */
    @Override
    public void buildFrame() {
        bike.setFrame("̼��ά����");
    }

    /**
     * ����
     */
    @Override
    public void buildSeat() {
        bike.setSeat("��Ƥ����");
    }

    /**
     * �������г��ķ���
     * @return
     */
    @Override
    public Bike createBike() {
        return bike;
    }
}
