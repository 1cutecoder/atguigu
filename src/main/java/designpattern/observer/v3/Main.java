package designpattern.observer.v3;
/**
 * 类描述
 *
 * @author zcl
 * @Description TODO
 * @Date 2021/12/20 21:28
 */
class  Child{

    private boolean cry = false;
    private Dad dad = new Dad();
    public void wakeup() {
        cry = true;
        dad.feed();
    }
}
class Dad{
    public void feed() {
        System.out.println("dad feeding ..........");
    }
}
public class Main {
    public static void main(String[] args) {
        Child child = new Child();
        child.wakeup();
    }
}
