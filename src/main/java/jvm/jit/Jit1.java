package jvm.jit;

/**
 * @author zcl
 * @date 2022/6/1 13:59
 * -XX:+PrintCompilation -XX:-DoEscapeAnalysis
 */
public class Jit1 {
    public static void main(String[] args) {
        for (int i = 0; i < 200; i++) {
            long start = System.nanoTime();
            for (int j = 0; j < 1000; j++) {
                new Object();
            }
            long end = System.nanoTime();
            System.out.printf("%d\t%d\n",i,(end - start));
        }
    }
}
