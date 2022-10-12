package leetcode.linkedist;

import leetcode.ListNode;

/**
 * 移除链表元素
 *
 * @author zcl
 * @Description 给你一个链表的头节点 head 和一个整数 val ，请你删除链表中所有满足 Node.val == val 的节点，并返回 新的头节点 。
 * 输入：head = [1,2,6,3,4,5,6], val = 6
 * 输出：[1,2,3,4,5]
 * 示例 2：
 * @Date 2022/8/6 11:11
 */
public class RemoveElements203a {
    static class Solution {
        public ListNode removeElements(ListNode head, int val) {
            if (head == null) {
                return head;
            }
            ListNode dummy = new ListNode(-1, head);
            ListNode pre = dummy;
            ListNode cur = head;
            while (cur != null) {
                if (cur.val == val) {
                    pre.next = cur.next;
                } else {
                    pre = cur;
                }
                cur = cur.next;
            }
            return dummy.next;
        }
    }

    public static void main(String[] args) {
        ListNode listNode = new ListNode(1);
        ListNode cur = listNode;
        int[] array = {1, 2, 6, 3, 4, 5, 6};
        for (int i = 1; i < array.length; i++) {

            ListNode newNode = new ListNode(array[i]);
            cur.next = newNode;
            cur = cur.next;
        }
        Solution solution = new Solution();
        solution.removeElements(listNode,6);
        while (listNode !=null) {
            System.out.println(listNode.val +"\t");
            listNode = listNode.next;
        }
    }
}
