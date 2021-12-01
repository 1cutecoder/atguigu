package designpattern.principles.demo4.before;

/**
 * @author zcl
 * @date 2021/12/1 13:55
 */
public class Client {
    public static void main(String[] args) {
        HeimaSafetyDoor heimaSafetyDoor = new HeimaSafetyDoor();
        heimaSafetyDoor.antiThref();
        heimaSafetyDoor.fireProof();
        heimaSafetyDoor.waterProof();
    }
}
