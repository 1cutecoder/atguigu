package designpattern.factory.abstract_factory;

/**
 * @author zcl
 * @date 2021/12/8 14:03
 */
public class ItalyDessertFactory implements DessertFactory {
    @Override
    public Coffee createCoffee() {
        return new LatteCoffee();
    }

    @Override
    public Dessert createDessert() {
        return new Tiramisu();
    }
}
