package juc.classicdemo;

import java.util.concurrent.TimeUnit;

/**
 * @author zcl
 * @date 2022/5/17 15:57
 */
public class Profiler {
    // 第一次get()方法调用时会进行初始化（如果set方法没有调用），每个线程会调用一次
    private static final ThreadLocal<Long> TIME_THREADLOCAL = new ThreadLocal<Long>() {
        protected Long initValue() {
            return System.currentTimeMillis();
        }
    };


    protected static final void begin() {
        TIME_THREADLOCAL.set(System.currentTimeMillis());
    }

    protected static final long end() {
        return System.currentTimeMillis() - TIME_THREADLOCAL.get();
    }

    public static void main(String[] args) throws InterruptedException {
        Profiler.begin();
        TimeUnit.SECONDS.sleep(1);
        System.out.println("Cost: " + Profiler.end() + " mills");

    }
}
