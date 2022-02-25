package designpattern.abstract_factory_and_builder;

/**
 * @author zcl
 * @date 2021/12/9 15:27
 */
public interface CarFactory {
    /**
     * ��������
     *
     * @return
     */
    public Wheel createWheel();

    /**
     * ��������
     *
     * @return
     */
    public BodyWork createBodyWork();

    /**
     * ����������
     *
     * @return
     */
    public Engine createEngine();

    /**
     * ��������
     *
     * @return
     */
    public Windows createWindows();

}
