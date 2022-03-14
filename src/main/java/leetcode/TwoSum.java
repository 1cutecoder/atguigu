package leetcode;

import java.util.HashMap;

/**
 * @author zcl
 * @date 2022/3/14 11:30
 */
public class TwoSum {
    public static int[] solution(int[] arr, int target) {
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            hashMap.put(arr[i], i);
        }
        for (int i = 0; i < arr.length; i++) {
            int key = target - arr[i];
            if (hashMap.containsKey(key)) {
                int index = hashMap.get(key);
                if (i != index) {
                    return new int[]{i,index};
                }
            }
        }
        return new int[]{-1,-1};
    }

    public static void main(String[] args) {
        int[] arr = {2, 7, 11, 15};
        int[] result = solution(arr, 26);
        System.out.println(result[0] + " " + result[1]);
    }

}
