package leetcode;

/**
 * @author zcl
 * @date 2021/11/24 18:07
 */
public class LengthOfLastWord58a {
    class Solution {
        public int lengthOfLastWord(String s) {
            int length =s.length();
            if(length == 1) {
                return 1;
            }
            for(int i = length -1;i >0; i-- ) {
                if((s.charAt(i) >= 'a' &&  s.charAt(i) <= 'z') || ((s.charAt(i) >= 'A' &&  s.charAt(i) <= 'Z'))) {
                    int index = i;
                    if(length == 1) {
                        return 1;
                    }
                    for(int j = i -1;j >=0 ;j--) {
                        if(s.charAt(j) == ' ') {
                            return (index - j );
                        }
                    }
                }
            }
            return 0;
        }
    }
}
