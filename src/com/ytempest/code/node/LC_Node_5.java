package com.ytempest.code.node;

import java.util.Stack;

/**
 * @author heqidu
 * @since 2021/3/9
 * <p>
 * 判断链表是否为回文链表
 */
class LC_Node_5 {

    public static void main(String[] args) {
        ListNode first = ListNode.createByArray(new int[]{1, 2, 3, 9, 3, 2, 1});
        System.out.println(ListNode.print(first));
        System.out.println(isPalindrome(first));

        boolean palindrome = new Solution().isPalindrome(first);
        System.out.println("palindrome=" + palindrome);
    }


    public static boolean isPalindrome(ListNode head) {
        ListNode tmp = head;
        Stack<ListNode> stack = new Stack<>();
        while (tmp != null) {
            stack.add(tmp);
            tmp = tmp.next;
        }

        tmp = head;
        while (tmp != null) {
            if (stack.pop().val != tmp.val) {
                return false;
            }
            tmp = tmp.next;
        }

        return true;
    }

    public static class Solution {
        public boolean isPalindrome(ListNode head) {
            if (head == null) {
                return true;
            }

            // 找到前半部分链表的尾节点并反转后半部分链表
            ListNode firstHalfEnd = endOfFirstHalf(head);
            ListNode secondHalfStart = reverseList(firstHalfEnd.next);

            // 判断是否回文
            ListNode p1 = head;
            ListNode p2 = secondHalfStart;
            boolean result = true;
            while (result && p2 != null) {
                if (p1.val != p2.val) {
                    result = false;
                }
                p1 = p1.next;
                p2 = p2.next;
            }

            // 还原链表并返回结果
            firstHalfEnd.next = reverseList(secondHalfStart);
            return result;
        }

        private ListNode reverseList(ListNode head) {
            ListNode prev = null;
            ListNode curr = head;
            while (curr != null) {
                ListNode nextTemp = curr.next;
                curr.next = prev;
                prev = curr;
                curr = nextTemp;
            }
            return prev;
        }

        /**
         * 当用慢指针 slow 遍历列表时，让另一个指针 fast 的速度是它的两倍。
         * 当 fast 到达列表的末尾时，slow 必然位于中间。
         */
        public ListNode endOfFirstHalf(ListNode head) {
            ListNode fast = head;
            ListNode slow = head;
            while (fast.next != null && fast.next.next != null) {
                fast = fast.next.next;
                slow = slow.next;
            }
            return slow;
        }
    }
}

