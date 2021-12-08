package designpattern.factory.config_factory;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/**
 * @author zcl
 * @date 2021/12/8 14:25
 */
public class CoffeeFactory {
    /**
     * 加载配置文件，获取配置文件中配置的全类名，并创建该类的对象进行存储
     */

    private static Map<String,Coffee> map = new HashMap<>();
    static {
        Properties properties = new Properties();
        InputStream inputStream = CoffeeFactory.class.getClassLoader().getResourceAsStream("bean.properties");
        try {
            properties.load(inputStream);
            for (Object key: properties.keySet()) {
                String className = properties.getProperty((String) key);
                Class<?> clazz = Class.forName(className);
                Coffee instance = (Coffee) clazz.newInstance();
                map.put((String)key,instance);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static Coffee createCoffee(String name) {
        return map.get(name);
    }
}
