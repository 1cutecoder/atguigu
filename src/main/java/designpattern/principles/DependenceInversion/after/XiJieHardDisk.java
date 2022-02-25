package designpattern.principles.DependenceInversion.after;

/**
 * @author zcl
 * @date 2021/11/29 16:21
 */
public class XiJieHardDisk implements HardDisk {
    @Override
    public void save(String data) {
        System.out.println("ʹ��ϣ��Ӳ�̴洢����" + data);
    }

    @Override
    public String get() {
        System.out.println("ʹ��ϣ��ϣ��Ӳ��ȡ����");
        return "����";
    }
}
