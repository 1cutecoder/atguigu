package designpattern.adapter.class_adapter;

/**
 * @author zcl
 * @date 2021/12/10 17:40
 */
public class TFCardImpl implements TFCard{
    @Override
    public String readTF() {
        return "hello TFCard";
    }

    @Override
    public void writeTF(String msg) {
        System.out.println("write msg into TFCard msg:" + msg);
    }
}
