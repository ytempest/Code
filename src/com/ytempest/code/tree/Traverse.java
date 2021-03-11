package com.ytempest.code.tree;

import java.util.LinkedList;

/**
 * @author heqidu
 * @since 2021/3/11
 */
class Traverse {
    // 先序遍历
    public static void leftTraverse(LinkedList<TreeNode> link, TreeNode node) {
        if (node == null) {
            return;
        }
        leftTraverse(link, node.left);
        link.add(node);
        leftTraverse(link, node.right);
    }

    // 中序遍历
    public static void middleTraverse(LinkedList<TreeNode> link, TreeNode node) {
        if (node == null) {
            return;
        }
        middleTraverse(link, node.left);
        link.add(node);
        middleTraverse(link, node.right);
    }

    // 后序遍历
    public static void rightTraverse(LinkedList<TreeNode> link, TreeNode node) {
        if (node == null) {
            return;
        }
        rightTraverse(link, node.left);
        link.add(node);
        rightTraverse(link, node.right);
    }
}
