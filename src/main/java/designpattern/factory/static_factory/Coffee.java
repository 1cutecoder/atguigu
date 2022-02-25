package designpattern.factory.static_factory;

/**
 * @author zcl
 * @date 2021/12/7 17:25
 */
public abstract class Coffee {
    public abstract String getName();


    public void addSugar() {
        System.out.println("����");
    }

    public void addMilk() {
        System.out.println("����");
    }
}
