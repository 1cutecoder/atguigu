package jvm;

/**
 * @author zcl
 * @date 2021/10/14 16:33
 */
public class OperandStackTest {
    public void testAndOperation() {
        //byte、short、char、boolean 都用int型来保存
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
        //获取上一个栈桢返回的结果
        int i = getSum();
        int j = 10;
    }

    /**
     * 常见的 i++和++i的区别
     */
    public void add() {
        //第一类问题
        int i1 = 10;
        i1++;
        int i2 = 10;
        ++i2;
        //第二类问题
        int i3 = 10;
        int i4 = i3++;
        int i5 = 10;
        int i6 = ++i3;
        //第三类问题
        int i7 = 10;
        i7 = i7++;
        int i8 = 10;
        i8 = ++i8;
        //第四类问题
        int i9 = 10;
        int i10 = i9++ + ++i9;
    }
}
