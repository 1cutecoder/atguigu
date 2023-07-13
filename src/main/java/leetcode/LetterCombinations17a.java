package leetcode;

import java.util.*;

/**
 * 类描述
 *
 * @author zcl
 * @Description 给定一个仅包含数字2-9的字符串，返回所有它能表示的字母组合。答案可以按 任意顺序 返回。
 * 2-> a、b、c 3->d、e、f
 * 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
 * @Date 2023/7/12 17:31
 */
public class LetterCombinations17a {
    static class Solution {


        public List<String> letterCombinations(String digits) {
            List result = new ArrayList<String>();
            StringBuffer buffer = new StringBuffer();

            String[] strs = digits.split("");
            if (digits.length() == 0){
                return result;
            }
            Map<String,String> map = new HashMap<String,String>();
            map.put("2","abc");
            map.put("3","def");
            map.put("4","ghi");
            map.put("5","jkl");
            map.put("6","mno");
            map.put("7","pqrs");
            map.put("8","tuv");
            map.put("9","wxyz");
            backTracking(result,buffer,strs,map,0);
            return result;
        }

        private void backTracking(List result, StringBuffer buffer, String[] strs, Map<String, String> map, int h) {
            if (buffer.length() == strs.length){
                result.add(buffer.toString());
                return;
            }
            String str = map.get(strs[h]);
            String[] strings = str.split("");
            for (int i = 0; i < strings.length; i++) {
                buffer.append(strings[i]);
                backTracking(result, buffer, strs,map,++h);
                buffer.delete(buffer.length() -1,buffer.length());
                --h;
            }
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String digits = "";
        List<String> strings = solution.letterCombinations(digits);
        for (String string : strings) {
            System.out.print(string+"\t");
        }
        //
        //输出：["ad","ae","af","bd","be","bf","cd","ce","cf"]
    }
}
