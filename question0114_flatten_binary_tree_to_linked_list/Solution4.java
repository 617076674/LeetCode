package question0114_flatten_binary_tree_to_linked_list;

/**
 * 前序遍历的本质：当前节点 -> 左子树 -> 右子树。
 *
 * 如果当前节点不存在左子树，显然不需要展开。
 *
 * 如果当前节点存在左子树，前序遍历时，当前节点的下一个节点就是其左孩子，需要寻找当前节点右孩子的前一个节点。
 *
 * 时间复杂度是 O(n)，其中 n 为树中的节点个数。空间复杂度是 O(1)。
 *
 * 执行用时：0ms，击败100.00%。消耗内存：39.3MB，击败93.44%。
 */
public class Solution4 {
  public void flatten(TreeNode root) {
    TreeNode cur = root;
    while (cur != null) {
      if (cur.left != null) {
        TreeNode next = cur.left;
        TreeNode pre = next;
        while (pre.right != null) {
          pre = pre.right;
        }
        pre.right = cur.right;
        cur.left = null;
        cur.right = next;
      }
      cur = cur.right;
    }
  }
}