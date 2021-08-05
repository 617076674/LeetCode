package question0863_all_nodes_distance_k_in_binary_tree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class Solution {

  private Map<TreeNode, TreeNode> map = new HashMap<>();

  public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
    List<Integer> result = new ArrayList<>();
    if (k == 0) {
      result.add(target.val);
      return result;
    }
    dfs(root, null);
    Set<TreeNode> visited = new HashSet<>();
    Queue<TreeNode> queue = new LinkedList<>();
    queue.add(target);
    visited.add(target);
    while (!queue.isEmpty()) {
      int qSize = queue.size();
      for (int i = 0; i < qSize; i++) {
        TreeNode cur = queue.poll();
        TreeNode parent = map.get(cur);
        if (null != parent && !visited.contains(parent)) {
          queue.add(parent);
          visited.add(parent);
        }
        if (null != cur.left && cur.left != parent && !visited.contains(cur.left)) {
          queue.add(cur.left);
          visited.add(cur.left);
        }
        if (null != cur.right && cur.right != parent && cur.right != cur.left && !visited.contains(cur.right)) {
          queue.add(cur.right);
          visited.add(cur.right);
        }
      }
      if (--k == 0) {
        break;
      }
    }
    while (!queue.isEmpty()) {
      result.add(queue.poll().val);
    }
    return result;
  }

  private void dfs(TreeNode treeNode, TreeNode parent) {
    if (null == treeNode) {
      return;
    }
    map.put(treeNode, parent);
    dfs(treeNode.left, treeNode);
    dfs(treeNode.right, treeNode);
  }

}
