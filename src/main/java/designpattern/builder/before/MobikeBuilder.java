package designpattern.builder.before;

/**
 * @author zcl
 * @date 2021/12/9 10:32
 */
public class MobikeBuilder extends Builder {
    /**
     * 车架
     */
    @Override
    public void buildFrame() {
        bike.setFrame("碳纤维车架");
    }

    /**
     * 车座
     */
    @Override
    public void buildSeat() {
        bike.setSeat("真皮车座");
    }

    /**
     * 构建自行车的方法
     * @return
     */
    @Override
    public Bike createBike() {
        return bike;
    }
}
