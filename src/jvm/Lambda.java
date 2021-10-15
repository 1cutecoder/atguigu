package jvm;


interface Func {
    public boolean func(String str);
}

/**
 * @author zcl
 * @date 2021/10/15 17:18
 */
public class Lambda {
    public Lambda() {
    }

    public void lambda(Func func) {
        return;
    }

    public static void main(String[] args) {
        Lambda lambda = new Lambda();
        Func func = s -> {
            return true;
        };
        lambda.lambda(func);
    }
}
