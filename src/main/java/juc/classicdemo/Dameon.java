package juc.classicdemo;

/**
 * @author zcl
 * @date 2022/4/29 14:32
 */
public class Dameon {
    public static void main(String[] args) {
        Thread thread = new Thread(() -> {
            try {
                SleepUtils.second(10);
            } finally {
                System.out.println("DaemonThread finally CODE BLOCK.");
            }
        }, "daemonThread");
        thread.setDaemon(true);
        thread.start();
    }
}
