package designpattern.abstract_factory_and_builder;

/**
 * @author zcl
 * @date 2021/12/9 15:27
 */
public interface CarFactory {
    /**
     * 创建轮子
     * @return
     */
    public  Wheel createWheel();

    /**
     * 创建车身
     * @return
     */
    public  BodyWork createBodyWork();

    /**
     * 创建发动机
     * @return
     */
    public  Engine createEngine();

    /**
     * 创建车窗
     * @return
     */
    public  Windows createWindows();

}
