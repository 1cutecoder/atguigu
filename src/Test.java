import juc.Noodles;

/**
 * @author zcl
 */
public class Test {
    public static void main(String[] args) {
        Noodles noodles = new Noodles();
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    for (int i = 0; i < 10; i++) {
                        noodles.makeNoodles();
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        }, "厨师A").start();
    new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    for (int i = 0; i < 10; i++) {
                        noodles.makeNoodles();
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        }, "厨师B").start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    for (int i = 0; i < 10; i++) {
                        noodles.eatNoodles();
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        }, "食客甲").start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    for (int i = 0; i < 10; i++) {
                        noodles.eatNoodles();
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        }, "食客乙").start();
    }
}
