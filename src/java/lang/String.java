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
         * ����: ���� java.lang.String ���Ҳ��� main ����, �뽫 main ��������Ϊ:
         *    public static void main(String[] args)
         * ���� JavaFX Ӧ�ó����������չjavafx.application.Application
         */
        System.out.println("This is main");
    }

}
