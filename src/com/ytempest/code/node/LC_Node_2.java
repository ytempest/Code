package com.ytempest.code.node;

/**
 * @author heqidu
 * @since 2021/3/9
 * <p>
 * 删除链表中倒数第n个节点
 */
class LC_Node_2 {

    public static void main(String[] args) {
        ListNode head = ListNode.create(5);

        System.out.println(ListNode.print(head));
        ListNode newHead = removeNthFromEnd(head, 2);
        System.out.println("head value=" + newHead.val);
        System.out.println(ListNode.print(newHead));
    }

    public static ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode quick = dummy;
        ListNode previous = dummy;
        for (int i = 0; i < n; i++) {
            quick = quick.next;
        }

        while (quick.next != null) {
            quick = quick.next;
            previous = previous.next;
        }
        previous.next = previous.next.next;
        return dummy.next;
    }


}
