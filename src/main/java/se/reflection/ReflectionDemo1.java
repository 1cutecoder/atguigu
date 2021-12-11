package se.reflection;

import java.io.FileReader;
import java.lang.reflect.Method;
import java.util.Properties;

/**
 * @author zcl
 * @date 2021/10/8 15:06
 */
public class ReflectionDemo1 {
    public static void main(String[] args) throws Exception{
        Properties properties = new Properties();
        FileReader reader = new FileReader("F:\\20210526demo\\src\\se\\properties\\a.properties");
        properties.load(reader);
        String className = properties.getProperty("className");
        Class<?> aClass = Class.forName(className);
        Object o = aClass.newInstance();
        Method show = aClass.getDeclaredMethod("show");
        show.invoke(o);
    }
}
