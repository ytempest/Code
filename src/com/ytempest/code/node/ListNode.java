package com.ytempest.code.node;

/**
 * @author heqidu
 * @since 2021/3/9
 */
public class ListNode {

    int val;
    ListNode next;

    public ListNode(int val) {
        this.val = val;
    }

    public ListNode(int val, ListNode head) {
        this.val = val;
        this.next = head;
    }

    public static String print(ListNode node) {
        StringBuilder sb = new StringBuilder();
        ListNode tmp = node;
        do {
            sb.append(tmp.val).append(", ");
            tmp = tmp.next;
        } while (tmp != null);
        return sb.toString();
    }

    public static ListNode create(int len) {
        return create(1, len);
    }

    public static ListNode create(int start, int len) {
        ListNode head = new ListNode(len);
        for (int i = len - 1; i >= start; i--) {
            ListNode current = new ListNode(i);
            current.next = head;
            head = current;
        }
        return head;
    }


    public static ListNode createByArray(int[] array) {
        ListNode head = new ListNode(array[0]);
        ListNode point = head;
        for (int i = 1; i < array.length; i++) {
            point.next = new ListNode(array[i]);
            point = point.next;
        }
        return head;
    }
}
