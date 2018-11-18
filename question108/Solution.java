package question108;

public class Solution {
    public TreeNode sortedArrayToBST(int[] nums) {
        TreeNode treeNode = null;
        if(nums.length == 0) {
            return treeNode;
        }
        int mid = nums.length / 2;
        treeNode = new TreeNode(nums[mid]);
        int[] leftNums = new int[mid];
        for (int i = 0; i < leftNums.length; i++) {
            leftNums[i] = nums[i];
        }
        int[] rightNums = new int[nums.length- mid - 1];
        for (int i = 0; i < rightNums.length; i++) {
            rightNums[i] = nums[i + mid + 1];
        }
        treeNode.left = sortedArrayToBST(leftNums);
        treeNode.right = sortedArrayToBST(rightNums);
        return treeNode;
    }
}
