import java.util.*;
/**
 * 类描述
 *
 * @author zcl
 * @Description TODO
 * @Date 2022/3/22 20:20
 */
public class LongestWorld {


    static class Solution {
        /**
         * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
         *
         * ["apple","iOS","dog","nana","man","good","goodman"]
         * @param words string字符串一维数组
         * @return string字符串
         */
        public String longestWord (String[] words) {
            List<String> strings = new LinkedList<>();
            Integer maxLength = words[0].length();
            strings.add(words[0]);
            for (int i = 1; i < words.length; i++) {
                int length = words[i].length();
                maxLength = strings.get(strings.size() - 1).length();
                if (length > maxLength) {
                    strings.clear();
                    strings.add(words[i]);
                } else if (length == maxLength) {
                    String s = strings.get(strings.size() - 1);
                    for (int j = 0; j < maxLength; j++) {
                        if ((s.charAt(j)-'A') <(-'A')){

                        }
                    }
                    strings.add(words[i]);
                }
            }
            if (strings.size() ==0) {
                return "";
            } else if (strings.size() == 1) {
                return strings.get(0);
            }
            for (int i = 0; i < strings.size(); i++) {

            }
            return null;
            // write code here
        }
    }

    public static void main(String[] args) {
        System.out.println('A');
        System.out.println('a');
    }
}
