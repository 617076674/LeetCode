package question0559_maximum_depth_of_n_ary_tree;

/**
 * 时间复杂度是O(n)，其中n是树中的节点个数。空间复杂度是O(h)，其中h是树的高度。
 */
public class Solution {

  public int maxDepth(Node root) {
    if (root == null) {
      return 0;
    }
    int max = 0;
    for (Node node : root.children) {
      max = Math.max(max, maxDepth(node));
    }
    return max + 1;
  }

}
