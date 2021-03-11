package com.ytempest.code.tree;

/**
 * @author heqidu
 * @since 2021/3/11
 * <p>
 * 验证二叉搜索树
 */
class LC_Tree_2 {
    public static void main(String[] args) {
        TreeNode root = TreeNode.createByArray(new Integer[]{5, 4, 6, null, null, 5, 7});
        TreeNode.print(root);

        System.out.println(isValidBST(TreeNode.createByArray(new Integer[]{1, 1, null})));
    }

    public static boolean isValidBST(TreeNode root) {
        return isValidBSTWithRange(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    public static boolean isValidBSTWithRange(TreeNode root, long lower, long up) {
        if (root == null) {
            return true;
        }
        if (root.val <= lower || up <= root.val) {
            return false;
        }
        return isValidBSTWithRange(root.left, lower, root.val)
                && isValidBSTWithRange(root.right, root.val, up);
    }
}