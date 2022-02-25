package designpattern.factory.simple_factory;

/**
 * @author zcl
 * @date 2021/12/7 17:29
 */
public class CoffeeStore {
    public Coffee orderCoffee(CoffeeType type) throws Exception {
        SimpleCoffeeFactory simpleCoffeeFactory = new SimpleCoffeeFactory();
        Coffee coffee = simpleCoffeeFactory.createCoffee(type);
        coffee.addMilk();
        coffee.addSugar();
        return coffee;
    }
}

