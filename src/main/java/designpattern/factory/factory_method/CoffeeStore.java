package designpattern.factory.factory_method;

/**
 * @author zcl
 * @date 2021/12/7 17:29
 */
public class CoffeeStore {
    private CoffeeFactory coffeeFactory;

    public void setCoffeeFactory(CoffeeFactory coffeeFactory) {
        this.coffeeFactory = coffeeFactory;
    }

    public Coffee orderCoffee() throws Exception {
        Coffee coffee = coffeeFactory.createCoffee();
        coffee.addMilk();
        coffee.addSugar();
        return coffee;
    }
}

