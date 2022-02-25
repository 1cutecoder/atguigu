package leetcode;

import java.util.ArrayList;

/**
 * @author zcl
 * @date 2022/1/13 14:15
 */
public class RecordList143a {
    static class Solution {
        public void reorderList(ListNode head) {
            if (head == null) {
                return;
            }
            ArrayList<ListNode> listNodes = new ArrayList<>();
            ListNode node = head;
            while (node != null) {
                listNodes.add(node);
                node = node.next;
            }
            int i = 0, j = listNodes.size() - 1;
            while (i < j) {
                listNodes.get(i).next = listNodes.get(j);
                i++;
                listNodes.get(j).next = listNodes.get(i);
                j--;
            }
            listNodes.get(i).next = null;
        }
    }

    public static void main(String[] args) {
        ListNode listNode = new ListNode(0);
        ListNode tempNode = listNode;
        for (int i = 1; i < 5; i++) {
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
