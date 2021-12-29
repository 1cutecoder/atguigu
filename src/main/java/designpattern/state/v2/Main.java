package designpattern.state.v2;

/**
 * @author zcl
 * @date 2021/12/29 10:55
 */
public class Main {
    public static void main(String[] args) {
        MM m1 = new MM("zhaofeiyan", new MMHappyStaste());
        m1.cry();
        m1.say();
        m1.smile();
        System.out.println("=======================");
        MM m2 = new MM("xishi", new MMSadStaste());
        m2.cry();
        m2.say();
        m2.smile();
        System.out.println("=======================");
        MM m3 = new MM("diaochan", new MMNervousStaste());
        m3.cry();
        m3.say();
        m3.smile();
    }
}
