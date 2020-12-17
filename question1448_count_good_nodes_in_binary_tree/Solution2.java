package question1448_count_good_nodes_in_binary_tree;

/**
 * 时间复杂度和空间复杂度均是 O(n)，其中 n 为树中的节点个数。
 *
 * 执行用时：2ms，击败100.00%。消耗内存：47.4MB，击败48.02%。
 */
public class Solution2 {

  private int result;

  public int goodNodes(TreeNode root) {
    goodNodes(root, Integer.MIN_VALUE);
    return result;
  }

  private void goodNodes(TreeNode treeNode, int preMax) {
    if (null == treeNode) {
      return;
    }
    if (treeNode.val >= preMax) {
      result++;
      preMax = treeNode.val;
    }
    goodNodes(treeNode.left, preMax);
    goodNodes(treeNode.right, preMax);
  }

}
