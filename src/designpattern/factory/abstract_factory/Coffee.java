package designpattern.factory.abstract_factory;

/**
 * @author zcl
 * @date 2021/12/7 17:25
 */
public abstract class Coffee {
    /**
     * 获取名称
     * @return
     */
    public abstract String getName();


    public void addSugar(){
        System.out.println("加糖");
    }
    public void addMilk(){
        System.out.println("加奶");
    }
}
