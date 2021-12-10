package designpattern.abstract_factory_and_builder;

/**
 * @author zcl
 * @date 2021/12/10 10:02
 */
public class HonDaCarFactory implements CarFactory {
    /**
     * ��������
     *
     * @return
     */
    @Override
    public Wheel createWheel() {
        return new HonDaWheel();
    }

    /**
     * ��������
     *
     * @return
     */
    @Override
    public BodyWork createBodyWork() {
        return new HonDaBodyWork();
    }

    /**
     * ����������
     *
     * @return
     */
    @Override
    public Engine createEngine() {
        return new HonDaEngine();
    }

    /**
     * ��������
     *
     * @return
     */
    @Override
    public Windows createWindows() {
        return new HonDaWindows();
    }
}
