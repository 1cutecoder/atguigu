package nbcode;

import java.util.*;

/**
 * @author zcl
 * @date 2022/4/11 15:19
 */
public class HJ8CombineTableRecord {
    static class Main {


        public void main() {
            Scanner scanner = new Scanner(System.in);
            TreeMap<Integer, Integer> treeMap = new TreeMap<>();
            int num = scanner.nextInt();
            for (int i = 0; i < num; i++) {
                int key = scanner.nextInt();
                int value = scanner.nextInt();
                if (treeMap.containsKey(key)) {
                    treeMap.put(key, treeMap.get(key) + value);
                } else {
                    treeMap.put(key, value);
                }
            }
            for (Integer key : treeMap.keySet()) {
                System.out.println(key + " " + treeMap.get(key));
            }
        }
    }

    public static void main(String[] args) {
        Main main = new Main();
        main.main();
    }
}
