package leetcode;

import java.util.*;

/**
 * @author zcl
 * @date 2021/12/7 9:22
 */
public class ValidBracket20a {
    class Solution {
        public boolean isValid(String s) {
            Map<Character, Character> characterMap = new HashMap<>();
            characterMap.put(')', '(');
            characterMap.put('}', '{');
            characterMap.put(']', '[');
            Stack<Character> characterStack = new Stack<>();
            char[] chars = s.toCharArray();
            for (char aChar : chars) {
                if (!characterStack.isEmpty() && characterMap.containsKey(aChar)) {
                    Character character = characterStack.pop();
                    if (!character.equals(characterMap.get(aChar))) {
                        return false;
                    }
                } else {
                    characterStack.push(aChar);
                }
            }
            if (!characterStack.isEmpty()) {
                return false;
            }
            return true;
        }
    }
}
