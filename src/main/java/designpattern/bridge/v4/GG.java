package designpattern.bridge.v4;

/**
 * @author zcl
 * @date 2021/12/28 15:54
 */
public class GG {
    public void chase(MM mm){
        Gift g = new WarmGift(new Flower());
        give(mm,g);

    }

    public void give(MM mm, Gift g) {
        System.out.println(g +"gived");

    }
}
