package leetcode;

/**
 * @author zcl
 * @date 2022/4/25 9:58
 */
public class TwoAdd2 {
    /**
     * Definition for singly-linked list.
     * public class ListNode {
     * int val;
     * ListNode next;
     * ListNode() {}
     * ListNode(int val) { this.val = val; }
     * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     * }
     */
    public static class Solution {
        public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
            int factor = 1;
            ListNode result = null;
            int accumelate = 0;
            while (l1 != null && l2 != null) {
                int temp = ((l1.val + l2.val + accumelate) % 10) * factor;
                ListNode newListNode = new ListNode(temp);
                if (result != null) {
                    result.next = newListNode;
                    result = result.next;
                } else {
                    result = newListNode;
                }
                accumelate = (l1.val + l2.val) / 10;
                l1 = l1.next;
                l2 = l2.next;
                factor = factor * 10;
            }
            if (accumelate > 0) {
                ListNode newListNode = new ListNode(accumelate);
                result.next = newListNode;
            }
            return result;
        }

    }
}
