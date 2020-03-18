package contest.question3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Solution {
    private List<Integer> inOrder = new ArrayList<>();

    public TreeNode balanceBST(TreeNode root) {
        inOrderTraversal(root);
        int[] nums = new int[inOrder.size()];
        for (int i = 0; i < nums.length; i++) {
            nums[i] = inOrder.get(i);
        }
        return sortedArrayToBST(nums);
    }

    private void inOrderTraversal(TreeNode root) {
        if (null == root) {
            return;
        }
        inOrderTraversal(root.left);
        inOrder.add(root.val);
        inOrderTraversal(root.right);
    }

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