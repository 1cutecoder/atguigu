package designpattern.factory.abstract_factory;

/**
 * @author zcl
 * @date 2021/12/8 14:06
 */
public class Client {
    /**
     * 抽象工厂模式多用于同一系列，如更换皮肤，多个图标配套改变
     * @param args
     */
    public static void main(String[] args) {
        ItalyDessertFactory italyDessertFactory = new ItalyDessertFactory();
        System.out.println("==============意大利风味甜品==========");
        Coffee coffee = italyDessertFactory.createCoffee();
        Dessert dessert = italyDessertFactory.createDessert();
        System.out.println(coffee.getName());
        dessert.show();
        System.out.println("==============美式风味甜品==============");
        AmericanDessertFactory americanDessertFactory = new AmericanDessertFactory();
        Coffee coffee1 = americanDessertFactory.createCoffee();
        Dessert dessert1 = americanDessertFactory.createDessert();
        System.out.println(coffee1.getName());
        dessert1.show();

    }
}
