package designpattern.prototype.clone;

/**
 * @author zcl
 * @date 2021/12/8 15:28
 */
public class Client {
    public static void main(String[] args) throws CloneNotSupportedException {
        Realizetype realizetype = new Realizetype();
        Realizetype clone = realizetype.clone();
        System.out.println("原型对象和克隆出来的是否是同一个对象？"+(realizetype == clone));
    }
}
