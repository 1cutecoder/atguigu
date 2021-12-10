package designpattern.factory.before;

/**
 * @author zcl
 * @date 2021/12/7 17:32
 */
public class Client {
    public static void main(String[] args) throws Exception {
        CoffeeStore coffeeStore = new CoffeeStore();
        Coffee coffee = coffeeStore.orderCoffee("american");
        System.out.println("您点的是" + coffee.getName());
        Coffee coffee2 = coffeeStore.orderCoffee("latte");
        System.out.println("您点的是" + coffee2.getName());
    }
}
