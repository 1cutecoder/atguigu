package designpattern.builder.before;

/**
 * @author zcl
 * @date 2021/12/9 10:20
 */
public abstract class Builder {
    protected Bike bike = new Bike();

    /**
     * 车架
     */
    public abstract void buildFrame();

    /**
     *  车座
     */
    public abstract void buildSeat();

    /**
     * 构建自行车的方法
     * @return
     */
    public abstract Bike createBike();


}
