package designpattern.principles.InterfaceSegregation.after;

/**
 * @author zcl
 * @date 2021/12/1 14:08
 */
public class ChuanzhiSafetyDoor implements AntiTheft,FireProof{
    @Override
    public void antiThef() {
        System.out.println("antiTheft");
    }

    @Override
    public void fireProof() {
        System.out.println("fireProof");
    }
}
