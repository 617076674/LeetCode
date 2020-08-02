package question0114_flatten_binary_tree_to_linked_list;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 一边迭代，一边展开。
 *
 * 时间复杂度和空间复杂度均是 O(n)，其中 n 为树中的节点个数。
 *
 * 执行用时：2ms，击败9.94%。消耗内存：39.6MB，击败39.07%。
 */
public class Solution3 {
  public void flatten(TreeNode root) {
    if (null == root) {
      return;
    }
    List<TreeNode> preOrder = new ArrayList<>();
    Stack<TreeNode> stack = new Stack<>();
    stack.push(root);
    TreeNode pre = null;
    while (!stack.isEmpty()) {
      TreeNode cur = stack.pop();
      if (null != pre) {
        pre.left = null;
        pre.right = cur;
      }
      pre = cur;
      preOrder.add(cur);
      //在访问本节点后先入栈右孩子，再入栈左孩子
      if (null != cur.right) {
        stack.push(cur.right);
      }
      if (null != cur.left) {
        stack.push(cur.left);
      }
    }
  }
}
