package jvm;

class Father {
    public Father() {
        System.out.println("father�Ĺ�����");
    }

    public static void showStatic(String str) {
        System.out.println("father " + str);
    }

    public final void showFinal() {
        System.out.println("father show final");
    }

    public void showCommon() {
        System.out.println("father ��ͨ����");
    }
}

/**
 * @author zcl
 * @date 2021/10/15 15:47
 * invokestatic��invokespecial���õ��Ƿ��鷽��
 */
public class Son extends Father {
    public Son() {
        super();
    }

    public Son(int age) {
        this();
    }

    //������д�ĸ���ķ���
    public static void showStatic(String str) {
        System.out.println("son " + str);
    }

    private void showPrivate(String str) {
        System.out.println("son private" + str);
    }

    public void show() {
        showStatic("atguigu.com");
        super.showStatic("good!");
        showPrivate("hello!");
        super.showCommon();
        //invokevirtual ��Ϊ�˷���������Ϊfinal���ܱ�������д����Ҳ��Ϊ�Ƿ��鷽��
        showFinal();
        super.showFinal();
        info();
        MethodInterface in = null;
        in.methodA();
    }

    public void info() {
    }

    interface MethodInterface {
        /**
         * ����
         */
        void methodA();
    }

    public static void main(String[] args) {
        Son son = new Son();
        son.show();
    }
}
