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
    }

    //练习
    public static void testStatic() {
        LocalVariablesTest test = new LocalVariablesTest();
        Date date = new Date();
        int count = 10;
        System.out.println(count);
    }

    /**
     * 关于slot的理解
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
        char gender = '男';
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
        //变量c使用之前已经销毁的变量b占据的slot位置
        int c = a+1;
    }
    /**
     * 变量的分类:
     *      按照数据类型份：1、基本数据类型 2、引用数据类型
     *      按照在类中声明的位置分：1、成员变量：
     *                              类变量：linking 的prepare阶段给了类变量默认赋值 -->initial阶段，给类变量显式赋值，调构造方法
     *                              实例变量：随着对象的创建，会在堆空间中分配实例变量空间，并进行默认赋值
     *                           2、局部变量
     */
    public void testTemp(){
        int num;
        //错误信息：变量num未初始化 Variable 'num' might not have been initialized
        // System.out.println(num);
    }
}
