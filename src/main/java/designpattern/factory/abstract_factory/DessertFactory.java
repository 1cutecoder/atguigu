package designpattern.factory.abstract_factory;

/**
 * @author zcl
 * @date 2021/12/8 14:00
 */
public interface DessertFactory {
    Coffee createCoffee();

    Dessert createDessert();
}
