package designpattern.principles.demo;

/**
 * @author zcl
 * @date 2021/11/29 15:18
 * @description À—π∑ ‰»Î∑®
 */
public class SougouImput {
    private AbstractSkin skin;

    public void setSkin(AbstractSkin skin) {
        this.skin = skin;
    }

    public void dispaly() {
        skin.display();
    }
}
