package question0437_path_sum_iii;

public class Solution {

  public int pathSum(TreeNode root, int targetSum) {
    if (root == null) {
      return 0;
    }
    return rootSum(root, targetSum) + pathSum(root.left, targetSum)
        + pathSum(root.right, targetSum);
  }

  public int rootSum(TreeNode root, int targetSum) {
    if (root == null) {
      return 0;
    }
    int ret = 0;
    if (root.val == targetSum) {
      ret++;
    }
    ret += rootSum(root.left, targetSum - root.val);
    ret += rootSum(root.right, targetSum - root.val);
    return ret;
  }

}