package question0993_cousins_in_binary_tree;

import java.util.LinkedList;
import java.util.Queue;

public class Solution {

  public boolean isCousins(TreeNode root, int x, int y) {
    int parentX = 0, parentY = 0, levelX = 0, levelY = 0;
    Queue<TreeNode> queue = new LinkedList<>();
    queue.add(root);
    int level = 0;
    while (!queue.isEmpty()) {
      int qSize = queue.size();
      for (int i = 0; i < qSize; i++) {
        TreeNode cur = queue.poll();
        if (cur.val == x) {
          levelX = level;
        } else if (cur.val == y){
          levelY = level;
        }
        if (null != cur.left) {
          queue.add(cur.left);
          if (cur.left.val == x) {
            parentX = cur.val;
          } else if (cur.left.val == y) {
            parentY = cur.val;
          }
        }
        if (null != cur.right) {
          queue.add(cur.right);
          if (cur.right.val == x) {
            parentX = cur.val;
          } else if (cur.right.val == y) {
            parentY = cur.val;
          }
        }
      }
      level++;
    }
    return parentX != parentY && levelX == levelY;
  }

}