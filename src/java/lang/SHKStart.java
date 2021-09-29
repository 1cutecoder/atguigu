package java.lang;

/**
 * @author zcl
 * @date 2021/9/29 16:22
 */
public class SHKStart {
    public static void main(String[] args) {
        /**
         * java.lang.SecurityException: Prohibited package name: java.lang
         * 	at sun.launcher.LauncherHelper.checkAndLoadMain(LauncherHelper.java:495)
         * Error: A JNI error has occurred, please check your installation and try again
         * Exception in thread "main"
         */
        System.out.println("hello");
    }
}
