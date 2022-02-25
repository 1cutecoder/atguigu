package designpattern.principles.InterfaceSegregation.before;

/**
 * @author zcl
 * @date 2021/12/1 13:52
 */
public class HeimaSafetyDoor implements SafetyDoor {
    @Override
    public void antiThref() {
        System.out.println("antiThref");
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
