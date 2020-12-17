package question1609_even_odd_tree;

import java.util.LinkedList;
import java.util.Queue;

public class Solution {

  public boolean isEvenOddTree(TreeNode root) {
    if (null == root) {
      return true;
    }
    Queue<TreeNode> queue = new LinkedList<>();
    queue.add(root);
    boolean isOdd = true;
    while (!queue.isEmpty()) {
      int qSize = queue.size();
      Integer pre = null;
      for (int i = 0; i < qSize; i++) {
        TreeNode now = queue.poll();
        if ((isOdd && ((null != pre && now.val <= pre) || (now.val & 1) == 0)) ||
            (!isOdd && ((null != pre && now.val >= pre) || (now.val & 1) == 1))) {
          return false;
        }
        pre = now.val;
        if (null != now.left) {
          queue.add(now.left);
        }
        if (null != now.right) {
          queue.add(now.right);
        }
      }
      isOdd = !isOdd;
    }
    return true;
  }

}