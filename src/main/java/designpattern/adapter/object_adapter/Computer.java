package designpattern.adapter.object_adapter;

/**
 * @author zcl
 * @date 2021/12/10 17:41
 */
public class Computer {
    public String readSD(SDCard sdCard) {
        if (sdCard == null) {
            throw new NullPointerException("sd card is null");
        }
        return sdCard.readSD();
    }
}
