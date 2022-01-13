package leetcode;

import java.util.ArrayList;

/**
 * @author zcl
 * @date 2022/1/13 14:15
 */
public class RecordList143b {
    static class Solution {
        public void reorderList(ListNode head) {
            ListNode middleNode = middleNode(head);
            ListNode reverseHead = reverseListNode(middleNode.next);
            middleNode.next = null;
            ListNode leftList = head;
            ListNode rightList = reverseHead;
            mergeListNode(leftList,rightList);
        }

        private void mergeListNode(ListNode leftList, ListNode rightList) {
            ListNode leftNode;
            ListNode rightNode;
            while (leftList != null && rightList != null) {
                leftNode = leftList.next;
                rightNode = rightList.next;
                leftList.next = rightList;
                leftList =leftNode;
                rightList.next = leftList;
                rightList = rightNode;
            }
        }

        private ListNode reverseListNode(ListNode listNode) {
            ListNode reverseHead = listNode, tail = listNode;
            while (tail.next != null) {
                ListNode temp = reverseHead;
                reverseHead = tail.next;
                tail.next = tail.next.next;
                reverseHead.next = temp;
            }
            return reverseHead;
        }

        private ListNode middleNode(ListNode head) {
            ListNode slow = head, fast = head;
            while (fast != null && fast.next != null) {
                slow = slow.next;
                fast = fast.next.next;
            }
            return slow;
        }
    }

    public static void main(String[] args) {
        ListNode listNode = new ListNode(1);
        ListNode tempNode = listNode;
        for (int i = 2; i < 8; i++) {
            ListNode node = new ListNode(i);
            tempNode.next = node;
            tempNode = tempNode.next;
        }
        Solution solution = new Solution();
        solution.reorderList(listNode);
        while (listNode != null) {
            System.out.println(listNode.val);
            listNode = listNode.next;
        }
    }
}
