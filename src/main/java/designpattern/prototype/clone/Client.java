package designpattern.prototype.clone;

/**
 * @author zcl
 * @date 2021/12/8 15:28
 */
public class Client {
    public static void main(String[] args) throws CloneNotSupportedException {
        Realizetype realizetype = new Realizetype();
        Realizetype clone = realizetype.clone();
        System.out.println("ԭ�Ͷ���Ϳ�¡�������Ƿ���ͬһ������" + (realizetype == clone));
    }
}
