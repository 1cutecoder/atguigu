package designpattern.factory.abstract_factory;

/**
 * @author zcl
 * @date 2021/12/8 14:06
 */
public class Client {
    /**
     * ���󹤳�ģʽ������ͬһϵ�У������Ƥ�������ͼ�����׸ı�
     *
     * @param args
     */
    public static void main(String[] args) {
        ItalyDessertFactory italyDessertFactory = new ItalyDessertFactory();
        System.out.println("==============�������ζ��Ʒ==========");
        Coffee coffee = italyDessertFactory.createCoffee();
        Dessert dessert = italyDessertFactory.createDessert();
        System.out.println(coffee.getName());
        dessert.show();
        System.out.println("==============��ʽ��ζ��Ʒ==============");
        AmericanDessertFactory americanDessertFactory = new AmericanDessertFactory();
        Coffee coffee1 = americanDessertFactory.createCoffee();
        Dessert dessert1 = americanDessertFactory.createDessert();
        System.out.println(coffee1.getName());
        dessert1.show();

    }
}
