package com.ytempest.code.tree;

import java.util.LinkedList;

/**
 * @author heqidu
 * @since 2021/3/11
 * <p>
 * 二叉树的最大深度
 */
class LC_Tree_1 {
    public static void main(String[] args) {
        TreeNode root = TreeNode.createByArray(new Integer[]{3, 9, 20, null, null, 15, 7, null, 1, 1, 1});
        TreeNode.print(root);

        System.out.println(maxDepth(root));
        System.out.println(maxDepth2(root));
    }

    public static int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }

    public static int maxDepth2(TreeNode root) {
        int depth = 0;
        // scope为最大宽度
        int scope = 0;
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int count = queue.size();
            int theScope = 0;
            for (int i = 0; i < count; i++) {
                TreeNode node = queue.removeFirst();
                if (node != null) {
                    if (node.left != null) queue.addLast(node.left);
                    if (node.right != null) queue.addLast(node.right);
                    theScope++;
                }
            }
            scope = Math.max(scope, theScope);
            depth++;
        }
        return depth;
    }
}
