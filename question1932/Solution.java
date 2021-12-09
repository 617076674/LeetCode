package question1932;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Solution {

  private Set<Integer> leavesSet = new HashSet<>();

  private Map<Integer, TreeNode> root2TreeNode = new HashMap<>();

  private int prev;

  public TreeNode canMerge(List<TreeNode> trees) {
    for (TreeNode tree : trees) {
      if (null != tree.left) {
        leavesSet.add(tree.left.val);
      }
      if (null != tree.right) {
        leavesSet.add(tree.right.val);
      }
      root2TreeNode.put(tree.val, tree);
    }
    for (TreeNode tree : trees) {
      if (!leavesSet.contains(tree.val)) {
        root2TreeNode.remove(tree.val);
        return (inOrderTraversal(tree) && root2TreeNode.isEmpty()) ? tree : null;
      }
    }
    return null;
  }

  private boolean inOrderTraversal(TreeNode tree) {
    if (null == tree) {
      return true;
    }
    if (null == tree.left && null == tree.right) {
      TreeNode candidate = root2TreeNode.get(tree.val);
      if (null != candidate) {
        tree.left = candidate.left;
        tree.right = candidate.right;
        root2TreeNode.remove(tree.val);
      }
    }
    if (!inOrderTraversal(tree.left)) {
      return false;
    }
    if (tree.val <= prev) {
      return false;
    }
    prev = tree.val;
    return inOrderTraversal(tree.right);
  }

}