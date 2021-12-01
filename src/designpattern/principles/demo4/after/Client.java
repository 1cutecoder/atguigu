package designpattern.principles.demo4.after;

/**
 * @author zcl
 * @date 2021/12/1 14:07
 */
public class Client {
    public static void main(String[] args) {
        HeimaSafetyDoor heimaSafetyDoor = new HeimaSafetyDoor();
        heimaSafetyDoor.antiThef();
        heimaSafetyDoor.fireProof();
        heimaSafetyDoor.waterProof();
        System.out.println("===================");
        ChuanzhiSafetyDoor chuanzhiSafetyDoor = new ChuanzhiSafetyDoor();
        chuanzhiSafetyDoor.antiThef();
        chuanzhiSafetyDoor.fireProof();
    }
}
