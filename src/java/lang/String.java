package java.lang;

/**
 * @author zcl
 * @date 2021/9/29 15:44
 */
public class String {
    static {
        System.out.println("String class's static code block");
    }

    public static void main(String[] args) {
        /**
         * 错误: 在类 java.lang.String 中找不到 main 方法, 请将 main 方法定义为:
         *    public static void main(String[] args)
         * 否则 JavaFX 应用程序类必须扩展javafx.application.Application
         */
        System.out.println("This is main");
    }

}
