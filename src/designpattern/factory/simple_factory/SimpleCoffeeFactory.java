package designpattern.factory.simple_factory;

/**
 * @author zcl
 * @date 2021/12/7 17:42
 */
public class SimpleCoffeeFactory {
    public Coffee createCoffee(String type) throws Exception {
        Coffee coffee;
        if ("american".equals(type)) {
            coffee = new AmericanCoffee();
        } else if ("latte".equals(type)) {
            coffee = new LatteCoffee();
        } else {
            System.out.println("�Բ���������Ŀ���û��");
            throw new Exception("�Բ���������Ŀ���û��");
        }
        return coffee;
    }
}
