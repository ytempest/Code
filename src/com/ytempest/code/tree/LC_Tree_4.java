package com.ytempest.code.tree;


import java.util.*;

/**
 * @author heqidu
 * @since 2021/3/11
 * <p>
 * 二叉树的层序遍历
 */
class LC_Tree_4 {

    public static void main(String[] args) {

        TreeNode root = TreeNode.createByArray(new Integer[]{1, 2, 2, 3, 4, 4, 3});
        TreeNode.print(root);
        List<List<Integer>> result = levelOrder(root);
        for (List<Integer> list : result) {
            System.out.println(Arrays.toString(list.toArray()));
        }
    }

    public static List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        Deque<TreeNode> queue = new LinkedList<>();
        queue.addLast(root);

        while (!queue.isEmpty()) {
            List<Integer> layer = new ArrayList<>();
            for (int i = 0, len = queue.size(); i < len; i++) {
                TreeNode node = queue.pollFirst();
                if (node != null) {
                    layer.add(node.val);
                    if (node.left != null) queue.addLast(node.left);
                    if (node.right != null) queue.addLast(node.right);
                }
            }
            result.add(layer);
        }
        return result;
    }
}