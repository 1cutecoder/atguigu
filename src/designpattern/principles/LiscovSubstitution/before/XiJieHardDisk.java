package designpattern.principles.LiscovSubstitution.before;

/**
 * @author zcl
 * @date 2021/11/29 16:21
 */
public class XiJieHardDisk {
    public void save(String data) {
        System.out.println("ʹ��ϣ��Ӳ�̴洢����" + data);
    }

    public String get() {
        System.out.println("ʹ��ϣ��ϣ��Ӳ��ȡ����");
        return "����";
    }
}
