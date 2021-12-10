package designpattern.builder.abstract_builder;

import designpattern.builder.before.Bike;

/**
 * @author zcl
 * @date 2021/12/9 10:45
 */
public abstract class Builder {
    protected Bike mBike = new Bike();

    /**
     * ����
     */
    public abstract void buildFrame();

    /**
     *  ����
     */
    public abstract void buildSeat();

    /**
     * �������г��ķ���
     * @return
     */
    public abstract Bike createBike();

    /**
     * �������г��ķ���
     * @return
     */
    public  Bike construct(){
        this.buildFrame();
        this.buildSeat();
        return this.createBike();
    }
}
