package leetcode.linkedist;

/**
 * 类描述
 *
 * @author zcl
 * @Description TODO
 * @Date 2022/10/10 20:40
 * 给定一个链表的头节点 head，返回链表开始入环的第一个节点。如果链表无环，则返回null。
 * 如果链表中有某个节点，可以通过连续跟踪 next 指针再次到达，则链表中存在环。 为了表示给定链表中的环，评测系统内部使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。如果 pos 是 -1，则在该链表中没有环。注意：pos 不作为参数进行传递，仅仅是为了标识链表的实际情况。
 * 不允许修改链表。
 * head = [3,2,0,-4], pos = 1
 */
public class DetectCycle142a {
    static class Solution {
        public ListNode detectCycle(ListNode head) {
            ListNode slow = head;
            ListNode fast = head;
            while (fast != null && fast.next != null) {
                slow = slow.next;
                fast = fast.next.next;
                if (slow == fast) {
                    ListNode index1 = fast;
                    ListNode index2 = head;
                    while (index1 != index2) {
                        index1 = index1.next;
                        index2 = index2.next;
                    }
                    return index1;
                }
            }
            return null;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        ListNode head = new ListNode();
        ListNode node0 = new ListNode(3);
        ListNode node1 = new ListNode(2);
        ListNode node2 = new ListNode(0);
        ListNode node3 = new ListNode(-4);
        head.next = node0;
        node0.next = node1;
        node1.next=node2;
        node2.next = node3;
        node3.next = node1;
        ListNode cycle = solution.detectCycle(node0);
        System.out.println("cycle = " + cycle.val);
    }
}
