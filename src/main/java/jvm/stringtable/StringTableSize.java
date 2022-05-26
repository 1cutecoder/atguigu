package jvm.stringtable;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author zcl
 * @date 2022/5/26 14:40
 * 演示串池大小对性能的影响
 * -Xms500m -Xmx500m -XX:+PrintStringTableStatistics -XX:StringTableSize=1009
 */
public class StringTableSize {
    public static void main(String[] args) throws IOException {
        System.in.read();
        List<String> list = new ArrayList<>();
        String line = null;
        for (int i = 0; i < 10; i++) {
            BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream("linux.words"), "utf-8"));
            long start = System.nanoTime();
            while (true) {
                line = reader.readLine();
                if (line == null) {
                    break;
                }
                //未入池 296 mb
                list.add(line);
                // 入池后 32mb
                //list.add(line.intern());
            }
            System.out.println("cost:" + (System.nanoTime() - start) / 1000);
        }
        System.in.read();

    }
}
