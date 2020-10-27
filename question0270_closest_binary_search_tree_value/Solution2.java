package question0270_closest_binary_search_tree_value;

/**
 * 二分查找。
 *
 * 时间复杂度是O(n)，其中n为树中的节点个数。空间复杂度是O(h)，其中h为树的高度。
 *
 * 执行用时：1ms，击败100.00%。消耗内存：38.1MB，击败100.00%。
 */
public class Solution2 {

  public int closestValue(TreeNode root, double target) {
    if (target > root.val) {
      if (root.right == null) {
        return root.val;
      }
      int rightResult = closestValue(root.right, target);
      return Math.abs(root.val - target) < Math.abs(rightResult - target) ? root.val : rightResult;
    }
    if (root.left == null) {
      return root.val;
    }
    int leftResult = closestValue(root.left, target);
    return Math.abs(root.val - target) < Math.abs(leftResult - target) ? root.val : leftResult;
  }

}