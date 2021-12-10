package designpattern.builder.before;

/**
 * @author zcl
 * @date 2021/12/9 10:32
 */
public class OfoBuilder extends Builder {
    /**
     * 车架
     */
    @Override
    public void buildFrame() {
        bike.setFrame("铝合金车架");
    }

    /**
     * 车座
     */
    @Override
    public void buildSeat() {
        bike.setSeat("橡胶车座");
    }

    /**
     * 构建自行车的方法
     *
     * @return
     */
    @Override
    public Bike createBike() {
        return bike;
    }
}
