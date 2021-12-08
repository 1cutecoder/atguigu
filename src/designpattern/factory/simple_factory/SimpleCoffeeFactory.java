package designpattern.factory.simple_factory;

import static designpattern.factory.simple_factory.CoffeeType.AMERICAN;

/**
 * @author zcl
 * @date 2021/12/7 17:42
 */
public class SimpleCoffeeFactory {
    /**
     * �����Ӹ������࣬����Ҫ�޸Ŀ��ȹ�������
     */
    public Coffee createCoffee(CoffeeType type) throws Exception {
        Coffee coffee;
        switch (type){
            case AMERICAN:
                coffee = new AmericanCoffee();
                break;
            case LATTE:
                coffee = new LatteCoffee();
                break;
            default:
                System.out.println("�Բ���������Ŀ���û��");
                throw new Exception("�Բ���������Ŀ���û��");
        }
        return coffee;
    }
}
