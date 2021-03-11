package com.ytempest.code.tree;

import java.util.LinkedList;

public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    public static TreeNode createByArray(Integer[] array) {
        LinkedList<TreeNode> link = new LinkedList<>();
        TreeNode root = new TreeNode(array[0]);
        link.add(root);

        int idx = 1;
        while (!link.isEmpty()) {
            TreeNode node = link.removeFirst();
            if (node != null) {
                Integer leftVal = getInt(array, idx++);
                Integer rightVal = getInt(array, idx++);
                node.left = leftVal != null ? new TreeNode(leftVal) : null;
                node.right = rightVal != null ? new TreeNode(rightVal) : null;

                link.add(node.left);
                link.add(node.right);
            }
        }
        return root;
    }

    @Override
    public String toString() {
        return String.valueOf(val);
    }

    public static void print(TreeNode root) {
        LinkedList<TreeNode> link = new LinkedList<>();
        link.add(root);

        while (!link.isEmpty()) {

            int len = link.size();
            while (len-- > 0) {
                TreeNode node = link.removeFirst();
                if (node != null) {
                    System.out.print(node.val + " ");
                    link.add(node.left);
                    link.add(node.right);
                } else {
                    System.out.print("null ");
                }
            }
            System.out.println();
        }
    }

    public static Integer getInt(Integer[] array, int idx) {
        return idx >= array.length ? null : array[idx];
    }
}