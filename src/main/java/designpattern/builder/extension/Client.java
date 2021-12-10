package designpattern.builder.extension;

/**
 * @author zcl
 * @date 2021/12/9 13:59
 */
public class Client {
    public static void main(String[] args) {
        Phone phone = new Phone.Builder()
                .cpu("intel")
                .screen("三星屏幕")
                .memory("金士顿内存条")
                .mainboard("华硕主板").build();
        System.out.println(phone.toString());
    }
}
