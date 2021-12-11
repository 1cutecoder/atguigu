package jvm;

/**
 * @author zcl
 * @date 2021/9/29 10:18
 */
public class ClassLoaderTest1 {
    public static void main(String[] args) {
        //��ȡϵͳ������� sun.misc.Launcher$AppClassLoader@18b4aac2
        ClassLoader systemClassLoader = ClassLoader.getSystemClassLoader();
        System.out.println(systemClassLoader);
        //��ȡ���ϲ㣺��չ������� sun.misc.Launcher$ExtClassLoader@4554617c
        ClassLoader extClassLoader = systemClassLoader.getParent();
        System.out.println(extClassLoader);
        //��ȡ���ϲ㣺null
        ClassLoader bootStrapClassLoader = extClassLoader.getParent();
        System.out.println(bootStrapClassLoader);
        //�����û��Զ�������˵ sun.misc.Launcher$AppClassLoader@18b4aac2
        //Ĭ��ʹ��ϵͳ�����������
        ClassLoader classLoader = ClassLoaderTest1.class.getClassLoader();
        System.out.println(classLoader);
        //String��ʹ����������������صģ�---->java�ĺ������ʹ����������������ص�
        //��ȡ���������null
        ClassLoader classLoader1 = String.class.getClassLoader();
        System.out.println(classLoader1);

    }
}
