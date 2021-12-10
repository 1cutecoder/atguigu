package designpattern.factory.abstract_factory;

/**
 * @author zcl
 * @date 2021/12/8 14:01
 */
public class AmericanDessertFactory implements DessertFactory{
    @Override
    public Coffee createCoffee() {
        return new AmericanCoffee();
    }

    @Override
    public Dessert createDessert() {
        return new MatchaMouse();
    }
}
