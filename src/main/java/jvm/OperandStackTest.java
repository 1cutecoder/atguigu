package jvm;

/**
 * @author zcl
 * @date 2021/10/14 16:33
 */
public class OperandStackTest {
    public void testAndOperation() {
        //byte��short��char��boolean ����int��������
        byte i = 15;
        int j = 8;
        int k = i + j;
        //int m = 8;
    }

    public int getSum() {
        int m = 10;
        int n = 20;
        int k = m + n;
        return k;
    }

    public void testGetSUM() {
        //��ȡ��һ��ջ�巵�صĽ��
        int i = getSum();
        int j = 10;
    }

    /**
     * ������ i++��++i������
     */
    public void add() {
        //��һ������
        int i1 = 10;
        i1++;
        int i2 = 10;
        ++i2;
        //�ڶ�������
        int i3 = 10;
        int i4 = i3++;
        int i5 = 10;
        int i6 = ++i3;
        //����������
        int i7 = 10;
        i7 = i7++;
        int i8 = 10;
        i8 = ++i8;
        //����������
        int i9 = 10;
        int i10 = i9++ + ++i9;
    }
}
