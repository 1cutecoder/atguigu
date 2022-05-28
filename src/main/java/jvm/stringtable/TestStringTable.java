package jvm.stringtable;

/**
 * @author zcl
 * @date 2022/5/26 14:12
 * -Xmx10m -XX:+PrintStringTableStatistics -XX:+PrintGCDetails -verbose:gc
 */
public class TestStringTable {
    public static void main(String[] args) {
        int i = 0;
        try {
            for (int j = 0; j < 50_000; j++) {
                String.valueOf(j).intern();
                i++;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            System.out.println(i);
        }
    }
}
