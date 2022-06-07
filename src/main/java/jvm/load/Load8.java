package jvm.load;

import java.io.IOException;
import java.io.InputStream;

/**
 * @author zcl
 * @date 2022/6/1 12:02
 * 类加载器与instanceof关键字演示
 */
public class Load8 {
        public static void main(String[] args) throws Exception {
            ClassLoader myLoader = new ClassLoader() {
                @Override
                public Class<?> loadClass(String name) throws ClassNotFoundException {
                    try {
                        String fileName = name.substring(name.lastIndexOf(".") + 1)+".class";
                        InputStream is = getClass().getResourceAsStream(fileName);
                        if (is == null) {
                            return super.loadClass(name);
                        }
                        byte[] b = new byte[is.available()];
                        is.read(b);
                        return defineClass(name, b, 0, b.length);
                    } catch (IOException e) {
                        throw new ClassNotFoundException(name);
                    }
                }
            };
            Object obj = myLoader.loadClass("jvm.load.Load8").newInstance();
            System.out.println(obj.getClass());
            System.out.println(obj instanceof jvm.load.Load8);
        }
}
