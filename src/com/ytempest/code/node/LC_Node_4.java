package com.ytempest.code.node;

/**
 * @author heqidu
 * @since 2021/3/9
 * <p>
 * 合并两个升序链表成一个升序链表
 */
class LC_Node_4 {

    public static void main(String[] args) {
        ListNode first = ListNode.create(5);
        ListNode second = ListNode.create(2, 4);

        System.out.println(ListNode.print(first));
        System.out.println(ListNode.print(second));

        ListNode result = mergeTwoLists(first, second);
        System.out.println("merge=" + ListNode.print(result));

        System.out.println(ListNode.print(first));
        System.out.println(ListNode.print(second));
    }

    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode prev = new ListNode(-1);
        ListNode tail = prev;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                tail.next = l1;
                l1 = l1.next;

            } else {
                tail.next = l2;
                l2 = l2.next;
            }
            tail = tail.next;
        }
        if (l1 != null) tail.next = l1;
        if (l2 != null) tail.next = l2;
        return prev.next;
    }
}