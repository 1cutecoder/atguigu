package leetcode;

/**
 * @author zcl
 * @date 2021/10/22 9:43
 */
public class PlusOne {
    static class Solution {
        public int[] plusOne(int[] digits) {
            for (int i = digits.length - 1; i >= 0; i--) {
                if (digits[i] != 9) {
                    for (int j = i; j < digits.length; j++) {
                        digits[j] = 0;
                    }
                    digits[i]++;
                    return digits;
                }
            }
            int[] newDigits = new int[digits.length + 1];
            for (int j = 0; j < digits.length; j++) {
                newDigits[j + 1] = digits[j];
            }
            return newDigits;

        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] digits = new int[]{0, 9};
        int[] plusOne = solution.plusOne(digits);
        for (int i : plusOne) {
            System.out.println("i = " + i);
        }
    }
}
