package designpattern.adapter.class_adapter;

/**
 * @author zcl
 * @date 2021/12/10 17:53
 */
public class SDAdapterTF extends TFCardImpl implements SDCard{
    @Override
    public String readSD() {
        System.out.println("adapter read tf card");
        return readTF();
    }

    @Override
    public void writeSD(String msg) {
        System.out.println("adapter write into tf card msg:" + msg);
        writeTF(msg);
    }
}
