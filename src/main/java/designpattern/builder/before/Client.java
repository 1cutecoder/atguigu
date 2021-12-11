package designpattern.builder.before;

/**
 * @author zcl
 * @date 2021/12/9 10:39
 */
public class Client {
    public static void main(String[] args) {
        Director director = new Director(new MobikeBuilder());
        Bike bike = director.construct();
        System.out.println("==============开始构建====================");
        System.out.println(bike.getFrame());
        System.out.println(bike.getSeat());
        System.out.println("==============结束构建====================");

    }
}
