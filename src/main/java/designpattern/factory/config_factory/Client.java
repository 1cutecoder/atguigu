package designpattern.factory.config_factory;

/**
 * @author zcl
 * @date 2021/12/8 14:38
 */
public class Client {
    public static void main(String[] args) {
        System.out.println("=================��ʽ����====================");
        Coffee coffee = CoffeeFactory.createCoffee("american");
        System.out.println(coffee.getName());
        System.out.println("=================��������====================");
        coffee = CoffeeFactory.createCoffee("latte");
        System.out.println(coffee.getName());
    }
}
