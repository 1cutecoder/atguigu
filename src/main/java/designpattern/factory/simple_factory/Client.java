package designpattern.factory.simple_factory;


/**
 * @author zcl
 * @date 2021/12/7 17:32
 */
public class Client {
    public static void main(String[] args) throws Exception {
        CoffeeStore coffeeStore = new CoffeeStore();
        Coffee coffee = coffeeStore.orderCoffee(CoffeeType.AMERICAN);
        System.out.println("您点的是" + coffee.getName());
        Coffee coffee2 = coffeeStore.orderCoffee(CoffeeType.LATTE);
        System.out.println("您点的是" + coffee2.getName());
    }
}
