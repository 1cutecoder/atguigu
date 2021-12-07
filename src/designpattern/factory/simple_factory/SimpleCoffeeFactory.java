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
            System.out.println("对不起，您所点的咖啡没有");
            throw new Exception("对不起，您所点的咖啡没有");
        }
        return coffee;
    }
}
