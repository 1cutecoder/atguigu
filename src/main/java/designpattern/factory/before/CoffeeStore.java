package designpattern.factory.before;

/**
 * @author zcl
 * @date 2021/12/7 17:29
 */
public class CoffeeStore {
    public Coffee orderCoffee(String type ) throws Exception {
        Coffee coffee = null;
        if ("american".equals(type)) {
            coffee = new AmericanCoffee();
        } else if ("latte".equals(type)) {
            coffee = new LatteCoffee();
        } else {
            System.out.println("对不起，您所点的咖啡没有");
            throw new Exception("对不起，您所点的咖啡没有");
        }
        coffee.addMilk();
        coffee.addSugar();
        return coffee;
    }
}

