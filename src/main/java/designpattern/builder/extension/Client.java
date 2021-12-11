package designpattern.builder.extension;

/**
 * @author zcl
 * @date 2021/12/9 13:59
 */
public class Client {
    public static void main(String[] args) {
        Phone phone = new Phone.Builder()
                .cpu("intel")
                .screen("������Ļ")
                .memory("��ʿ���ڴ���")
                .mainboard("��˶����").build();
        System.out.println(phone.toString());
    }
}
