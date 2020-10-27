package question0545_boundary_of_binary_tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Solution {

  private List<Integer> result = new ArrayList<>();

  public List<Integer> boundaryOfBinaryTree(TreeNode root) {
    findLeftBoundary(root);
    findLeaves(root);
    findRightBoundary(root);
    return result;
  }

  private void findLeftBoundary(TreeNode root) {
    if (null == root) {
      return;
    }
    if (null != root.left || null != root.right) {
      result.add(root.val);
    }
    TreeNode cur = root.left;
    while (cur != null) {
      if (null != cur.left || null != cur.right) {
        result.add(cur.val);
      }
      if (cur.left != null) {
        cur = cur.left;
      } else {
        cur = cur.right;
      }
    }
  }

  private void findLeaves(TreeNode root) {
    if (null == root) {
      return;
    }
    if (root.left == null && root.right == null) {
      result.add(root.val);
    }
    findLeaves(root.left);
    findLeaves(root.right);
  }

  private void findRightBoundary(TreeNode root) {
    Stack<TreeNode> stack = new Stack<>();
    if (null == root) {
      return;
    }
    TreeNode cur = root.right;
    while (cur != null) {
      stack.add(cur);
      if (cur.right != null) {
        cur = cur.right;
      } else {
        cur = cur.left;
      }
    }
    while (!stack.isEmpty()) {
      TreeNode now = stack.pop();
      if (now.left == null && now.right == null) {
        continue;
      }
      result.add(now.val);
    }
  }

}