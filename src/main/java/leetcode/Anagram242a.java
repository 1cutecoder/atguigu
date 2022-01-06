package leetcode;

import designpattern.factory.config_factory.Coffee;
import designpattern.factory.config_factory.CoffeeFactory;

import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

/**
 * @author zcl
 * @date 2022/1/6 13:46
 */
public class Anagram242a {
    static class Solution {
        public boolean isAnagram(String s, String t) {
            Map<Character, Integer> sMap = new HashMap<>();
            Map<Character, Integer> tMap = new HashMap<>();
            for (int i = 0; i < s.length(); i++) {
                char sc = s.charAt(i);
                char tc = t.charAt(i);
                if (sMap.containsKey(sc)) {
                    sMap.put(sc, sMap.get(sc) + 1);
                } else {
                    sMap.put(sc, 1);

                }
                if (tMap.containsKey(tc)) {
                    tMap.put(tc, tMap.get(tc) + 1);
                } else {
                    tMap.put(tc, 1);

                }
            }
            Set<Character> keySet = sMap.keySet();
            for (Character character : keySet) {
                if (sMap.get(character).equals(tMap.get(character))) {
                    return false;
                }
            }
            return true;
        }
    }
}
