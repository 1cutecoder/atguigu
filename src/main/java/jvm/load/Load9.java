package jvm.load;

/**
 * @author zcl
 * @date 2022/6/1 10:41
 * 访问静态内部类的staic成员变量（非String，非基本数据类型）时才会进行内部类的初始化
 */
public class Load9 {
    public static void main(String[] args) {
//Singleton.test();
        Singleton instance = Singleton.getInstance();
    }
}

class Singleton {
    private Singleton() {
    }

    public static void test() {
        System.out.println("test");
    }

    private static class LazyHolder {
        private static final Singleton SINGLETON = new Singleton();

        static {
            System.out.println("lazy holder init");
        }
    }

    public static Singleton getInstance() {
        return LazyHolder.SINGLETON;
    }
}
