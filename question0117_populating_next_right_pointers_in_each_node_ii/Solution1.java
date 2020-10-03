package question0117_populating_next_right_pointers_in_each_node_ii;

import java.util.LinkedList;

/**
 * 递归实现。
 *
 * 时间复杂度和空间复杂度均是 O(n)，其中 n 为树中的节点个数。
 *
 * 执行用时：1ms，击败58.38%。消耗内存：38.5MB，击败57.11%。
 */
public class Solution1 {

  public Node connect(Node root) {
    dfs(root, 0, new LinkedList<>());
    return root;
  }

  // linkedList[i]用来存储第i层的一个节点
  private void dfs(Node root, int level, LinkedList<Node> linkedList) {
    if (null == root) {   //如果root为null，直接返回
      return;
    }
    if (linkedList.size() > level) {
      Node node = linkedList.get(level);
      node.next = root;
      linkedList.remove(level);
    }
    linkedList.add(level, root);
    dfs(root.left, level + 1, linkedList);
    dfs(root.right, level + 1, linkedList);
  }

}