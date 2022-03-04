package leetcode.class01;

/**
 * @author zcl
 * @date 2022/3/4 9:40
 * @description bit calculation
 */
public class Code07_EvenTimes {
    /**
     * [a,a,a,b,b,c,c]
     * a ^ a ^ a = a
     * b ^ b = 0
     * c ^ c=0
     */
    public static void printOddTimesNum1(int[] arr) {
        int eor = 0;
        for (int cur : arr) {
            eor ^= cur;
        }
        System.out.println("eor = " + eor);
    }

    public static void printOddTimesNum2(int[] arr) {
        int eor = 0, onlyOne = 0;
        for (int curNum : arr) {
            eor ^= curNum;
        }
        int rightOne = eor & (~eor + 1);
        for (int cur : arr) {
            if ((cur & rightOne) == 0) {
                onlyOne ^= cur;
            }
        }
        System.out.println("first num: " + onlyOne);
        System.out.println("second num: " + (onlyOne ^ eor));

    }

    public static void main(String[] args) {
        int[] arr = new int[]{1, 1, 1, 1, 2, 2, 3, 3, 3};
        System.out.println("=======================printOddTimesNum1=======================");
        printOddTimesNum1(arr);
        System.out.println("===============================================================");
        int[] arr1 = new int[]{1, 1, 1, 1, 2, 2, 3, 3, 3,4,4,4};
        System.out.println("=======================printOddTimesNum2=======================");
        printOddTimesNum2(arr1);
        System.out.println("===============================================================");

    }
}

