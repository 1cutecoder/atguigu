package designpattern.factory.simple_factory;

import static designpattern.factory.simple_factory.CoffeeType.AMERICAN;

/**
 * @author zcl
 * @date 2021/12/7 17:42
 */
public class SimpleCoffeeFactory {
    /**
     * 后续加个咖啡类，还需要修改咖啡工厂代码
     */
    public Coffee createCoffee(CoffeeType type) throws Exception {
        Coffee coffee;
        switch (type){
            case AMERICAN:
                coffee = new AmericanCoffee();
                break;
            case LATTE:
                coffee = new LatteCoffee();
                break;
            default:
                System.out.println("对不起，您所点的咖啡没有");
                throw new Exception("对不起，您所点的咖啡没有");
        }
        return coffee;
    }
}
