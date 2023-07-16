package od;

import java.util.*;

/**
 * 类描述
 *
 * @author zcl
 * @Description TODO
 * @Date 2023/7/16 14:59
 */
public class CharacterCalculateAndSort {

    public static void main(String[] args) {
        String s = "xxxxxcyyddABABABABCCCCCYYcc";
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            if (!map.containsKey(s.charAt(i))) {
                map.put(s.charAt(i), 1);
            } else
                map.put(s.charAt(i), map.get(s.charAt(i)) + 1);
        }

        List<Map.Entry<Character, Integer>> list = new ArrayList<>(map.entrySet());
        System.out.println(list);
        Collections.sort(list, new Comparator<Map.Entry<Character, Integer>>() {
            @Override
            public int compare(Map.Entry<Character, Integer> m1, Map.Entry<Character, Integer> m2) {
                if (m1.getValue().equals(m2.getValue())) {
                    if ((int) m1.getKey() < 97 && (int) m2.getKey() >= 97) {
                        return m2.getKey() - m1.getKey();
                    }
                    return m1.getKey() - m2.getKey();

                }
                return m2.getValue() - m1.getValue();
            }
        });
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < list.size() - 1; i++) {
            sb.append(list.get(i).getKey()).append(":").append(list.get(i).getValue()).append(";");
        }
        sb.append(list.get(list.size() - 1).getKey()).append(":").append(list.get(list.size() - 1).getValue());
        System.out.println(sb.toString());
    }


}
