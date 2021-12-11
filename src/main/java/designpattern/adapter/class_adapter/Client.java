package designpattern.adapter.class_adapter;

/**
 * @author zcl
 * @date 2021/12/10 17:51
 */
public class Client {
    public static void main(String[] args) {
        Computer computer = new Computer();
        String msg = computer.readSD(new SDCardImpl());
        System.out.println("msg = " + msg);
        System.out.println("=================================");
        String readSD = computer.readSD(new SDAdapterTF());
        System.out.println("readSD = " + readSD);
    }
}
