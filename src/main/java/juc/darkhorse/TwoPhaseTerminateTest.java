package juc.darkhorse;

import java.util.concurrent.TimeUnit;

/**
 * @author zcl
 * @date 2022/6/6 10:39
 */
public class TwoPhaseTerminateTest {
    public static void main(String[] args) {
        TwoPhaseTermination tpt = new TwoPhaseTermination();
        tpt.start();
        try {TimeUnit.SECONDS.sleep(3);} catch (InterruptedException e) {e.printStackTrace();}
        tpt.stop();

    }
}

class TwoPhaseTermination {
    private Thread monitor;

    public void start() {
        monitor = new Thread(() -> {
            while (true) {
                Thread current = Thread.currentThread();
                if (current.isInterrupted()) {
                    System.out.println("料理后事");
                    break;
                }
                try {
                    TimeUnit.SECONDS.sleep(1);
                    System.out.println("执行监控记录");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                    //重新设置打断标记
                    current.interrupt();
                }
            }
        }, "");
        monitor.start();
    }
    //停止监控线程
    public void stop() {
        monitor.interrupt();
    }
}
