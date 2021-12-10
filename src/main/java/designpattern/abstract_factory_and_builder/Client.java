package designpattern.abstract_factory_and_builder;

/**
 * @author zcl
 * @date 2021/12/10 10:01
 */
public class Client {
    public static void main(String[] args) {
        HonDaCarFactory honDaCarFactory = new HonDaCarFactory();
        BodyWork bodyWork = honDaCarFactory.createBodyWork();
        Wheel wheel = honDaCarFactory.createWheel();


        Car car = new Car.Builder()
                .bodyWork(honDaCarFactory.createBodyWork())
                .wheel(honDaCarFactory.createWheel())
                .engine(honDaCarFactory.createEngine())
                .windows(honDaCarFactory.createWindows()).build();

        System.out.println(car);
    }
}
