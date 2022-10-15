package leetcode.linkedist;

import java.util.HashMap;

/**
 * 类描述
 *
 * @author zcl
 * @Description 你两个单链表的头节点headA 和 headB ，请你找出并返回两个单链表相交的起始节点。如果两个链表没有交点，返回 null 。
 * <p>
 * 图示两个链表在节点 c1 开始相交：
 * a1 --> a2 --> c1 -->c2 -->c3
 * /\
 * |
 * b1 -->b2 -->b3
 * @Date 2022/10/14 23:11
 */
public class IntersectionNodeInterview0207 {
    static class Solution {
        public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
            HashMap<ListNode, Integer> in = new HashMap<>();
            ListNode curA = headA;
            ListNode curB = headB;
            int lenA = 0, lenB = 0;
            while (curA != null) {
                lenA++;
                curA = curA.next;
            }
            while (curB != null) {
                lenB++;
                curB = curB.next;
            }
            curA = headA;
            curB = headB;
            //让链表长的交换成A
            if (lenA < lenB) {
                ListNode temp = curA;
                curA = curB;
                curB = temp;
                int tempLen = lenA;
                lenA = lenB;
                lenB = tempLen;
            }
            int step = lenA - lenB;
            for (int i = 0; i < step; i++) {
                curA = curA.next;
            }
            while (curA != null) {
                if (curA == curB) {
                    return curA;
                }
                curA = curA.next;
                curB = curB.next;
            }
            return null;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        ListNode lista = new ListNode();
        ListNode listb = new ListNode();
        ListNode nodea0 = new ListNode(4);
        ListNode nodea1 = new ListNode(1);
        ListNode nodeb0 = new ListNode(5);
        ListNode nodeb1 = new ListNode(0);
        ListNode nodeb2 = new ListNode(1);
        ListNode node3 = new ListNode(8);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        lista.next = nodea0;
        nodea0.next = nodea1;
        nodea1.next = node3;
        listb.next = nodeb0;
        nodeb0.next = nodeb1;
        nodeb1.next = nodeb2;
        nodeb2.next = node3;
        node3.next = node4;
        node4.next = node5;
        ListNode intersectionNode = solution.getIntersectionNode(lista, listb);
        System.out.println("intersectionNode = " + intersectionNode.toString());
    }
}
