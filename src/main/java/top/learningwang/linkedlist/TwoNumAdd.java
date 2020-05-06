package top.learningwang.linkedlist;

import java.util.List;

/**
 * @author wangjingbiao
 * createTime: 2020/5/6 下午4:22
 * desc: 题号2,链表中的两数相加
 */
public class TwoNumAdd {
    public static void main(String[] args) {
        Solution solution = new Solution();
        ListNode l1 = new ListNode(9);

        ListNode l2 = new ListNode(1);
        l2.next = new ListNode(9);
        l2.next.next = new ListNode(9);
        l2.next.next.next = new ListNode(9);
        l2.next.next.next.next = new ListNode(9);
        l2.next.next.next.next.next = new ListNode(9);
        l2.next.next.next.next.next.next = new ListNode(9);
        l2.next.next.next.next.next.next.next = new ListNode(9);
        l2.next.next.next.next.next.next.next.next = new ListNode(9);
        l2.next.next.next.next.next.next.next.next.next = new ListNode(9);
        ListNode listNode = solution.addTwoNumbers(l1, l2);
        do {
            System.out.print(listNode.val + " -> ");
            listNode = listNode.next;
        } while (listNode != null);
        System.out.println();
    }

    static class Solution {
        public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
            long sum = transferListNodeToNum(l1) + transferListNodeToNum(l2);
            return transferNumToListNode(sum);
        }

        public long transferListNodeToNum(ListNode l) {
            long value = 0;
            int i = 0;
            do {
                value += l.val * Math.pow(10, i);
                i++;
                l = l.next;
            } while (l != null);
            return value;
        }

        public ListNode transferNumToListNode(long num) {
            String s = String.valueOf(num);
            ListNode root = null;
            ListNode node = null;
            for (int i = s.length() - 1; i >= 0; i--) {
                int value = Integer.parseInt(String.valueOf(s.charAt(i)));
                if (root == null) {
                    root = new ListNode(value);
                    node = root;
                } else {
                    node.next = new ListNode(value);
                    node = node.next;
                }
            }
            return root;
        }
    }

    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
