package lcci0402_minimum_height_tree;

/**
 * 执行用时：0ms，击败100.00%。消耗内存：39.4MB，击败100.00%。
 */
public class Solution {
    public TreeNode sortedArrayToBST(int[] nums) {
        return sortedArrayToBST(nums, 0, nums.length - 1);
    }

    private TreeNode sortedArrayToBST(int[] nums, int left, int right) {
        if (left > right) {
            return null;
        }
        if (left == right) {
            return new TreeNode(nums[left]);
        }
        int mid = left + ((right - left) >> 1);
        TreeNode treeNode = new TreeNode(nums[mid]);
        treeNode.left = sortedArrayToBST(nums, left, mid - 1);
        treeNode.right = sortedArrayToBST(nums, mid + 1, right);
        return treeNode;
    }
}