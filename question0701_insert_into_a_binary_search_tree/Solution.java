package question0701_insert_into_a_binary_search_tree;

/**
 * 递归。
 *
 * 时间复杂度和空间复杂度均是 O(n)，其中 n 为树中的节点个数。
 *
 * 执行用时：0ms，击败100.00%。消耗内存：39.8MB，击败5.02%。
 */
public class Solution {

  public TreeNode insertIntoBST(TreeNode root, int val) {
    if (null == root) {
      return new TreeNode(val);
    }
    if (root.val > val) {
      root.left = insertIntoBST(root.left, val);
    } else {
      root.right = insertIntoBST(root.right, val);
    }
    return root;
  }

}