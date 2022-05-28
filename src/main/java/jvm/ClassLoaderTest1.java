package jvm;

/**
 * @author zcl
 * @date 2021/9/29 10:18
 */
public class ClassLoaderTest1 {
    public static void main(String[] args) {
        //获取系统类加载器 sun.misc.Launcher$AppClassLoader@18b4aac2
        ClassLoader systemClassLoader = ClassLoader.getSystemClassLoader();
        System.out.println(systemClassLoader);
        //获取其上层：拓展类加载器 sun.misc.Launcher$ExtClassLoader@4554617c
        ClassLoader extClassLoader = systemClassLoader.getParent();
        System.out.println(extClassLoader);
        //获取其上层：null
        ClassLoader bootStrapClassLoader = extClassLoader.getParent();
        System.out.println(bootStrapClassLoader);
        //对于用户自定义类来说 sun.misc.Launcher$AppClassLoader@18b4aac2
        //默认使用系统类加载器加载
        ClassLoader classLoader = ClassLoaderTest1.class.getClassLoader();
        System.out.println(classLoader);
        //String是使用引导类加载器加载的，---->java的核心类库使用引导类加载器加载的
        //获取其加载器：null
        ClassLoader classLoader1 = String.class.getClassLoader();
        System.out.println(classLoader1);

    }
}
