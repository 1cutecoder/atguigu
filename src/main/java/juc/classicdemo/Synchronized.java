package juc.classicdemo;

/**
 * @author zcl
 * @date 2022/4/29 15:33
 */
public class Synchronized {
    /**
     * public static void main(java.lang.String[]);
     * // 方法修饰符，表示：public staticflags: ACC_PUBLIC, ACC_STATIC
     * Code:
     * stack=2, locals=1, args_size=1
     * 0: ldc #1　　// class com/murdock/books/multithread/book/Synchronized
     * 2: dup
     * 3: monitorenter　　// monitorenter：监视器进入，获取锁
     * 4: monitorexit　　// monitorexit：监视器退出，释放锁
     * 5: invokestatic　　#16 // Method m:()V
     * 8: return
     * public static synchronized void m();
     * // 方法修饰符，表示： public static synchronized
     * flags: ACC_PUBLIC, ACC_STATIC, ACC_SYNCHRONIZED
     * Code:
     * stack=0, locals=0, args_size=0
     * 0: return
     */
    public static void main(String[] args) {
        // 对Synchronized Class对象进行加锁
        synchronized (Synchronized.class) {
        }
        // 静态同步方法，对Synchronized Class对象进行加锁
        m();
    }

    public static synchronized void m(){
    }
}
