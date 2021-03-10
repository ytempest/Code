package com.ytempest.code.node;

/**
 * @author heqidu
 * @since 2021/3/9
 * <p>
 * 判断链表是否有环
 */
class LC_Node_6 {

    public static void main(String[] args) {
        ListNode head = ListNode.create(5);
        ListNode tail = head;
        while (tail.next != null) {
            tail = tail.next;
        }
        System.out.println(ListNode.print(head));
        System.out.println(tail.val);

        System.out.println(hasCycle(head));
        System.out.println("pro=" + hasCyclePro(head));
        // 加环
        tail.next = head.next.next;
        System.out.println(hasCycle(head));
        System.out.println("pro=" + hasCyclePro(head));

    }

    public static boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) return false;
        ListNode fast = head.next;
        ListNode slow = head;
        while (fast != null && slow != null) {
            if (fast == slow) {
                return true;
            }
            fast = fast.next == null ? null : fast.next.next;
            slow = slow.next;
        }

        return false;
    }

    public static boolean hasCyclePro(ListNode head) {
        if (head == null || head.next == null) return false;
        ListNode fast = head.next;
        ListNode slow = head;
        while (slow != fast) {
            if (fast == null || fast.next == null) {
                return false;
            }
            slow = slow.next;
            fast = fast.next.next;
        }

        return true;
    }
}