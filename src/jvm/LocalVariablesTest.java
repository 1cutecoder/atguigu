package jvm;

import java.util.Date;

/**
 * @author zcl
 * @date 2021/10/13 16:45
 */
public class LocalVariablesTest {
    private int count = 0;

    public static void main(String[] args) {
        LocalVariablesTest test = new LocalVariablesTest();
        int num = 10;
        test.test1();
    }

    //��ϰ
    public static void testStatic() {
        LocalVariablesTest test = new LocalVariablesTest();
        Date date = new Date();
        int count = 10;
        System.out.println(count);
    }

    /**
     * ����slot�����
     */
    public LocalVariablesTest() {
        this.count = 1;
    }

    public void test1() {
        Date date = new Date();
        String name1 = "atguigu.com";
        String info = test2(date, name1);
        System.out.println(date + name1);
    }

    public String test2(Date date, String name1) {
        date = null;
        name1 = "songhongkang";
        double weight = 120.5;
        char gender = '��';
        return date + name1;
    }

    public void test3() {
        count++;
    }

    public void test4() {
        int a = 0;
        {
            int b = 0;
            b = a + 1;
        }
        //����cʹ��֮ǰ�Ѿ����ٵı���bռ�ݵ�slotλ��
        int c = a+1;
    }
}
