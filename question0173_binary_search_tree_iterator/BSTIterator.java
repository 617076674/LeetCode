package question0173_binary_search_tree_iterator;

import java.util.LinkedList;

public class BSTIterator {

  private LinkedList<TreeNode> stack = new LinkedList<>();

  public BSTIterator(TreeNode root) {
    pushToStack(root);
  }

  public int next() {
    TreeNode node = stack.pop();
    TreeNode cur = node;
    if (null != cur.right) {
      cur = cur.right;
      pushToStack(cur);
    }
    return node.val;
  }

  public boolean hasNext() {
    return !stack.isEmpty();
  }

  private void pushToStack(TreeNode treeNode) {
    TreeNode cur = treeNode;
    while (cur != null) {
      stack.push(cur);
      if (cur.left != null) {
        cur = cur.left;
      } else {
        break;
      }
    }
  }

}
