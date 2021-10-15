package jvm;

class Father {
    public Father() {
        System.out.println("father的构造器");
    }

    public static void showStatic(String str) {
        System.out.println("father " + str);
    }

    public final void showFinal() {
        System.out.println("father show final");
    }

    public void showCommon() {
        System.out.println("father 普通方法");
    }
}

/**
 * @author zcl
 * @date 2021/10/15 15:47
 * invokestatic和invokespecial调用的是非虚方法
 */
public class Son extends Father {
    public Son() {
        super();
    }

    public Son(int age) {
        this();
    }
//不是重写的父类的方法
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
        //invokevirtual 因为此方法被声明为final不能被子类重写，故也认为是非虚方法
        showFinal();
        super.showFinal();
        info();
        MethodInterface in = null;
        in.methodA();
    }

    public void info() {
    }
interface MethodInterface{
    /**
     * 测试
     */
    void methodA();
}
    public static void main(String[] args) {
        Son son = new Son();
        son.show();
    }
}
