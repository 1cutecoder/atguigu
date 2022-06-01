package jvm.load;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * @author zcl
 * @date 2022/6/1 10:57
 */
public class Load7 {
    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        MyClassLoader classLoader = new MyClassLoader();
        Class<?> mapImpl1 = classLoader.loadClass("MapImpl1");
        Object instance = mapImpl1.newInstance();
        System.out.println("instance.toString() = " + instance.toString());
    }

}

class MyClassLoader extends ClassLoader {

    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        String path = "f:\\myclasspath\\" + name + ".class";
        ByteArrayOutputStream os = new ByteArrayOutputStream();
        try {
            Files.copy(Paths.get(path), os);
            byte[] bytes = os.toByteArray();
            return defineClass(name, bytes, 0, bytes.length);
        } catch (IOException e) {
            e.printStackTrace();
            throw new ClassNotFoundException("类文件未找到", e);
        }
    }
}
