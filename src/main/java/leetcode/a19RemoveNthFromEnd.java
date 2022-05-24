package leetcode;

/**
 * @author zcl
 * @date 2022/5/24 16:12
 * 给你一个链表，删除链表的倒数第 n 个结点，并且返回链表的头结点。
 * 输入：head = [1,2,3,4,5], n = 2
 * 输出：[1,2,3,5]
 * 输入：head = [1], n = 1
 * 输出：[]
 * 输入：head = [1,2], n = 1
 * 输出：[1]
 */
public class a19RemoveNthFromEnd {
    static class Solution {
        public ListNode removeNthFromEnd(ListNode head, int n) {
            ListNode pre = head;
            ListNode cur = head;
            int index = 0;
            int preIndex = 0;
            if (head.next == null && n == 1) {
                return null;
            }
            if (n == 1) {
                while (cur.next != null) {
                    pre = cur;
                    cur = cur.next;
                }
                pre.next = null;
                return head;
            }
            ListNode suc = head.next.next;
            while (cur.next != null) {
                cur = cur.next;
                index++;
                if ((index - preIndex ) > n) {
                    pre = pre.next;
                    suc = suc.next;
                    preIndex++;
                }
            }
            if((index - preIndex ) == n) {
                return head.next;
            }
            pre.next = suc;
            return head;
        }
    }

    public static void main(String[] args) {
        ListNode listNode5 = new ListNode(5);
        ListNode listNode4 = new ListNode(4, listNode5);
        ListNode listNode3 = new ListNode(3, listNode4);
        ListNode listNode2 = new ListNode(2, listNode3);
        ListNode listNode1 = new ListNode(1, listNode2);
        Solution solution = new Solution();
        solution.removeNthFromEnd(listNode1, 2);
        while (listNode1 != null) {
            System.out.print(listNode1.val + " ");
            listNode1 = listNode1.next;
        }
    }
}
