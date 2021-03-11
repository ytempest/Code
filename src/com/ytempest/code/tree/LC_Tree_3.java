package com.ytempest.code.tree;


/**
 * @author heqidu
 * @since 2021/3/11
 * <p>
 * 对称二叉树
 */
class LC_Tree_3 {

    public static void main(String[] args) {

        TreeNode root = TreeNode.createByArray(new Integer[]{1, 2, 2, 3, 4, 4, 3});
        TreeNode.print(root);
        System.out.println(isSymmetric(root));

        System.out.println();

        TreeNode errTree = TreeNode.createByArray(new Integer[]{1, 2, 2, 3, 4, null, 3});
        TreeNode.print(errTree);
        System.out.println(isSymmetric(errTree));
    }

    public static boolean isSymmetric(TreeNode root) {
        return isMirroring(root, root);
    }

    public static boolean isMirroring(TreeNode left, TreeNode right) {
        if (left == null && right == null) {
            return true;
        }
        if (left == null || right == null) {
            return false;
        }
        return left.val == right.val && isMirroring(left.left, right.right) && isMirroring(left.right, right.left);
    }

}
