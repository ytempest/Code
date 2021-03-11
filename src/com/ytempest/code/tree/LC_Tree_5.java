package com.ytempest.code.tree;


/**
 * @author heqidu
 * @since 2021/3/11
 * <p>
 * 将有序数组转换为二叉搜索树
 */
class LC_Tree_5 {

    public static void main(String[] args) {
        int[] nums = {-10, -3, 0, 5, 9};
        TreeNode root = sortedArrayToBST(nums);
        TreeNode.print(root);
    }

    public static TreeNode sortedArrayToBST(int[] nums) {
        return dispatch(nums, 0, nums.length - 1);
    }

    public static TreeNode dispatch(int[] nums, int start, int end) {
        if (start > end) {
            return null;
        }
        int center = (start + end) / 2;
        TreeNode root = new TreeNode(nums[center]);
        root.left = dispatch(nums, start, center - 1);
        root.right = dispatch(nums, center + 1, end);

        return root;
    }
}