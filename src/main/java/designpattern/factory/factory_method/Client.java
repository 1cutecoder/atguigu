package designpattern.factory.factory_method;


/**
 * @author zcl
 * @date 2021/12/7 17:32
 */
public class Client {
    public static void main(String[] args) throws Exception {
        CoffeeStore coffeeStore = new CoffeeStore();
        coffeeStore.setCoffeeFactory(new AmericanCoffeeFactory());
        Coffee coffee = coffeeStore.orderCoffee();
        System.out.println("�������" + coffee.getName());
        coffeeStore.setCoffeeFactory(new LatteFactory());
        Coffee coffee2 = coffeeStore.orderCoffee();
        System.out.println("�������" + coffee2.getName());
    }
}
