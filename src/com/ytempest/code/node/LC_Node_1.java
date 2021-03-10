package com.ytempest.code.node;

/**
 * @author heqidu
 * @since 2021/3/9
 * <p>
 * 删除链表中的节点
 */
class LC_Node_1 {
    public static void main(String[] args) {
        ListNode node = new ListNode(1);
        ListNode tmp = node;
        for (int i = 2; i < 6; i++) {
            ListNode listNode = new ListNode(i);
            tmp.next = listNode;
            tmp = listNode;
        }
        System.out.println(node.toString());
        ListNode next = node.next.next;
        System.out.println("delete=" + next.val);
        deleteNode(next);
        System.out.println(node.toString());


    }

    public static void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }


}
