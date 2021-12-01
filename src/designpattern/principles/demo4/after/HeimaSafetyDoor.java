package designpattern.principles.demo4.after;

/**
 * @author zcl
 * @date 2021/12/1 14:06
 */
public class HeimaSafetyDoor implements AntiTheft,WaterProof,FireProof{
    @Override
    public void antiThef() {
        System.out.println("antiTheft");
    }

    @Override
    public void fireProof() {
        System.out.println("fireProof");
    }

    @Override
    public void waterProof() {
        System.out.println("waterProof");
    }
}
