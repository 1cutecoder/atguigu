package designpattern.factory.factory_method;

/**
 * @author zcl
 * @date 2021/12/8 10:13
 */
public class AmericanCoffeeFactory implements CoffeeFactory {
    @Override
    public Coffee createCoffee() {
        return new AmericanCoffee();
    }
}
