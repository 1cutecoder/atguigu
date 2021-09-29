package jvm;

import com.sun.java.accessibility.util.Translator;
import sun.misc.Launcher;

import java.net.URL;
import java.security.Provider;

/**
 * @author zcl
 * @date 2021/9/29 10:18
 */
public class ClassLoaderTest {
    public static void main(String[] args) {
        System.out.println("***********************�����������***************************");
        //��ȡBootStrapClassLoader�ܹ����ص�api��·��
        URL[] urLs = Launcher.getBootstrapClassPath().getURLs();
        for (URL urL : urLs) {
            System.out.println(urL.toExternalForm());
        }
        //�������·��������ѡ��һ���࣬����������ʲô
        ClassLoader classLoader = Provider.class.getClassLoader();
        System.out.println("Provider.class.getClassLoader(): " + classLoader);
        System.out.println("**********************��չ�������**************************************");
        String extDirs = System.getProperty("java.ext.dirs");
        for (String path : extDirs.split(";")) {
            System.out.println(path);
        }
        ClassLoader classLoader1 = Translator.class.getClassLoader();
        System.out.println("Translator.class.getClassLoader(): " + classLoader1);
    }
}
