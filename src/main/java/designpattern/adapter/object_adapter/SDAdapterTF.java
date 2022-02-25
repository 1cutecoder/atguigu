package designpattern.adapter.object_adapter;

/**
 * @author zcl
 * @date 2021/12/10 17:53
 */
public class SDAdapterTF implements SDCard {
    private TFCard tfCard;

    public SDAdapterTF(TFCard tfCard) {
        this.tfCard = tfCard;
    }

    @Override
    public String readSD() {
        System.out.println("adapter read tf card");
        return tfCard.readTF();
    }

    @Override
    public void writeSD(String msg) {
        System.out.println("adapter write into tf card msg:" + msg);
        tfCard.writeTF(msg);
    }
}
