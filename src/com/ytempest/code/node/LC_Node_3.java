package com.ytempest.code.node;

/**
 * @author heqidu
 * @since 2021/3/9
 * <p>
 * 反转链表
 */
class LC_Node_3 {

    public static void main(String[] args) {
        ListNode head = ListNode.create(5);

        System.out.println(ListNode.print(head));
        System.out.println(ListNode.print(reverseList(head)));
        System.out.println(ListNode.print(head));

        ListNode pro = ListNode.create(8);
        System.out.println(ListNode.print(pro));
        System.out.println(ListNode.print(reverseListPro(pro)));
        System.out.println(ListNode.print(pro));

    }

    public static ListNode reverseList(ListNode head) {
        ListNode dummy = new ListNode(-1);
        ListNode tmp = head;
        while (tmp != null) {
            // 这里先从原队列取出节点
            ListNode current = tmp;
            tmp = current.next;
            current.next = null;

            ListNode currentHead = dummy.next;
            dummy.next = current;
            dummy.next.next = currentHead;

        }
        return dummy.next;
    }

    public static ListNode reverseListPro(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }

}
