package designpattern.abstract_factory_and_builder;

/**
 * @author zcl
 * @date 2021/12/10 10:02
 */
public class HonDaCarFactory implements CarFactory {
    /**
     * 创建轮子
     *
     * @return
     */
    @Override
    public Wheel createWheel() {
        return new HonDaWheel();
    }

    /**
     * 创建车身
     *
     * @return
     */
    @Override
    public BodyWork createBodyWork() {
        return new HonDaBodyWork();
    }

    /**
     * 创建发动机
     *
     * @return
     */
    @Override
    public Engine createEngine() {
        return new HonDaEngine();
    }

    /**
     * 创建车窗
     *
     * @return
     */
    @Override
    public Windows createWindows() {
        return new HonDaWindows();
    }
}
