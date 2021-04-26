package question1080_insufficient_nodes_in_root_to_leaf_paths;

public class Solution {

  private boolean dfs(TreeNode node, int s, int limit) {
    if (node.left == null && node.right == null) {
      return s + node.val < limit;
    }
    // 注意：如果 dfs 的返回值的意义是这个结点是否被删除，它们的默认值应该设置为 true
    boolean lTreeDeleted = true, rTreeDeleted = true;
    if (node.left != null) {
      lTreeDeleted = dfs(node.left, s + node.val, limit); // 如果有左子树，就先递归处理左子树
    }
    if (node.right != null) {
      rTreeDeleted = dfs(node.right, s + node.val, limit);  // 如果有右子树，就先递归处理右子树
    }
    // 左右子树是否保留的结论得到了，由自己来执行是否删除它们
    if (lTreeDeleted) {
      node.left = null;
    }
    if (rTreeDeleted) {
      node.right = null;
    }
    return lTreeDeleted && rTreeDeleted;  // 只有左右子树都被删除了，自己才没有必要保留
  }

  public TreeNode sufficientSubset(TreeNode root, int limit) {
    return dfs(root, 0, limit) ? null : root;
  }

}