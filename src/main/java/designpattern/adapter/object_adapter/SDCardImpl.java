package designpattern.adapter.object_adapter;

/**
 * @author zcl
 * @date 2021/12/10 17:43
 */
public class SDCardImpl implements SDCard{

    @Override
    public String readSD() {
        return "hello SD Card";
    }

    @Override
    public void writeSD(String msg) {
        System.out.println("write into SD Card msg:" +msg);
    }
}
