package jvm;

/**
 * @author zcl
 * @date 2021/9/29 10:18
 */
public class ClassLoaderTest2 {
    public static void main(String[] args) {
        try {
            //1.
            ClassLoader classLoader = Class.forName("java.lang.String").getClassLoader();
            System.out.println(classLoader);
            //2.��ǰ�߳�
            ClassLoader contextClassLoader = Thread.currentThread().getContextClassLoader();
            System.out.println(contextClassLoader);
            //3.��ȡϵͳ�������-->��չ�������
            ClassLoader parent = ClassLoader.getSystemClassLoader().getParent();
            System.out.println(parent);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
