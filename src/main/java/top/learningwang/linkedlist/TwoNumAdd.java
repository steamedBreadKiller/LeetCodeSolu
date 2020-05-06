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
        ListNode l1 = getLinkedListByArray(new int[]{1, 8, 3});
        ListNode l2 = getLinkedListByArray(new int[]{1, 2, 7});
        ListNode listNode = solution.addTwoNumbers2(l1, l2);
        do {
            System.out.print(listNode.val + " -> ");
            listNode = listNode.next;
        } while (listNode != null);
        System.out.println();
    }

    public static ListNode getLinkedListByArray(int[] arr) {
        if (arr == null || arr.length < 1) {
            return null;
        }
        ListNode root = new ListNode(arr[0]);
        ListNode currentNode = root;
        for (int i = 1; i < arr.length; i++) {
            currentNode.next = new ListNode(arr[i]);
            currentNode = currentNode.next;
        }
        // 返回头节点
        return root;
    }

    static class Solution {
        public ListNode addTwoNumbers2(ListNode l1, ListNode l2) {
            ListNode root = null;
            ListNode currentNode = null;
            // 两数之和
            int sum;
            // 两数之和大于10，保留个位数，十位数计入下位累加
            int addExtra = 0;
            do {
                // 根据位置取数，判断是否为空
                int value1 = (l1 == null) ? 0 : l1.val;
                int value2 = (l2 == null) ? 0 : l2.val;

                // 两数相加，加上进位数，保留个位数，十位数计入下次累加
                sum = value1 + value2 + addExtra;
                addExtra = sum / 10;
                int value = sum % 10;

                // 将值加入链表中，并判断是否是根节点
                if (root == null) {
                    root = new ListNode(value);
                    currentNode = root;
                } else {
                    currentNode.next = new ListNode(value);
                    currentNode = currentNode.next;
                }

                // 下移一位
                if (l1 != null) {
                    l1 = l1.next;
                }

                if (l2 != null) {
                    l2 = l2.next;
                }
            } while (l1 != null || l2 != null);

            // 最后一位超出10，溢出一位
            if (addExtra != 0) {
                currentNode.next = new ListNode(addExtra);
            }
            return root;
        }

        // 方法2，存在溢出的问题
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
