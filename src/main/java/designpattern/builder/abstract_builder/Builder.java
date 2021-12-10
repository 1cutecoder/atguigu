package designpattern.builder.abstract_builder;

import designpattern.builder.before.Bike;

/**
 * @author zcl
 * @date 2021/12/9 10:45
 */
public abstract class Builder {
    protected Bike mBike = new Bike();

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

    /**
     * 构建自行车的方法
     * @return
     */
    public  Bike construct(){
        this.buildFrame();
        this.buildSeat();
        return this.createBike();
    }
}
