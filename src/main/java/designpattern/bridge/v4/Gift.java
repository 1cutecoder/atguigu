package designpattern.bridge.v4;

/**
 * @author zcl
 * @date 2021/12/28 15:55
 */
public abstract class Gift {
    GiftImpl impl;

    public Gift(GiftImpl impl) {
        this.impl = impl;
    }
}
