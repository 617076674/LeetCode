package question2096;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class Solution {

  private Map<Integer, TreeNode> val2ParentTreeNode = new HashMap<>();

  private Map<Integer, TreeNode> val2TreeNode = new HashMap<>();

  private static class QueueNode {
    int val;
    StringBuilder path = new StringBuilder();

    public QueueNode(int val) {
      this.val = val;
    }
  }

  public String getDirections(TreeNode root, int startValue, int destValue) {
    dfs(root, null);
    Queue<QueueNode> queue = new LinkedList<>();
    Set<Integer> visitedSet = new HashSet<>();
    queue.add(new QueueNode(startValue));
    visitedSet.add(startValue);
    while (!queue.isEmpty()) {
      int qSize = queue.size();
      for (int i = 0; i < qSize; i++) {
        QueueNode curNode = queue.poll();
        if (curNode.val == destValue) {
          return curNode.path.toString();
        }
        if (val2TreeNode.get(curNode.val).left != null && !visitedSet.contains(val2TreeNode.get(curNode.val).left.val)) {
          QueueNode nextNode = new QueueNode(val2TreeNode.get(curNode.val).left.val);
          nextNode.path = new StringBuilder(curNode.path).append("L");
          queue.add(nextNode);
          visitedSet.add(val2TreeNode.get(curNode.val).left.val);
        }
        if (val2TreeNode.get(curNode.val).right != null && !visitedSet.contains(val2TreeNode.get(curNode.val).right.val)) {
          QueueNode nextNode = new QueueNode(val2TreeNode.get(curNode.val).right.val);
          nextNode.path = new StringBuilder(curNode.path).append("R");
          queue.add(nextNode);
          visitedSet.add(val2TreeNode.get(curNode.val).right.val);
        }
        if (val2ParentTreeNode.get(curNode.val) != null && !visitedSet.contains(val2ParentTreeNode.get(curNode.val).val)) {
          QueueNode nextNode = new QueueNode(val2ParentTreeNode.get(curNode.val).val);
          nextNode.path = new StringBuilder(curNode.path).append("U");
          queue.add(nextNode);
          visitedSet.add(val2ParentTreeNode.get(curNode.val).val);
        }
      }
    }
    return null;
  }

  private void dfs(TreeNode cur, TreeNode parent) {
    if (null == cur) {
      return;
    }
    val2ParentTreeNode.put(cur.val, parent);
    val2TreeNode.put(cur.val, cur);
    dfs(cur.left, cur);
    dfs(cur.right, cur);
  }

}