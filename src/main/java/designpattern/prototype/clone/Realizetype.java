package designpattern.prototype.clone;

/**
 * @author zcl
 * @date 2021/12/8 15:26
 */
public class Realizetype implements Cloneable {
    public Realizetype() {
        System.out.println("�����ԭ�Ͷ��󴴽���ɣ�");
    }

    @Override
    protected Realizetype clone() throws CloneNotSupportedException {
        System.out.println("�����ԭ�Ͷ����Ƴɹ���");
        return (Realizetype) super.clone();
    }
}
