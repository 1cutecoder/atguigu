package designpattern.builder.before;

/**
 * @author zcl
 * @date 2021/12/9 10:20
 */
public abstract class Builder {
    protected Bike bike = new Bike();

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


}
