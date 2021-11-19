package lcp44_sZ59z6;

import java.util.HashSet;
import java.util.Set;

public class Solution {

  private Set<Integer> colorSet = new HashSet<>();

  public int numColor(TreeNode root) {
    dfs(root);
    return colorSet.size();
  }

  private void dfs(TreeNode treeNode) {
    if (null == treeNode) {
      return;
    }
    colorSet.add(treeNode.val);
    dfs(treeNode.left);
    dfs(treeNode.right);
  }

}