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
        System.out.println("***********************启动类加载器***************************");
        //获取BootStrapClassLoader能够加载的api的路径
        URL[] urLs = Launcher.getBootstrapClassPath().getURLs();
        for (URL urL : urLs) {
            System.out.println(urL.toExternalForm());
        }
        //从上面的路径中随意选择一个类，看加载器是什么
        ClassLoader classLoader = Provider.class.getClassLoader();
        System.out.println("Provider.class.getClassLoader(): " + classLoader);
        System.out.println("**********************拓展类加载器**************************************");
        String extDirs = System.getProperty("java.ext.dirs");
        for (String path : extDirs.split(";")) {
            System.out.println(path);
        }
        ClassLoader classLoader1 = Translator.class.getClassLoader();
        System.out.println("Translator.class.getClassLoader(): " + classLoader1);
    }
}
