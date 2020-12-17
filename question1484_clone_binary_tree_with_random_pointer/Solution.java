package question1484_clone_binary_tree_with_random_pointer;

import java.util.HashMap;
import java.util.Map;

/**
 * 执行用时：7ms，击败100.00%。消耗内存：39.8MB，击败74.16%。
 */
public class Solution {

  private Map<Node, NodeCopy> map = new HashMap<>();

  public NodeCopy copyRandomBinaryTree(Node root) {
    if (null == root) {
      return null;
    }
    NodeCopy originNodeCopy = map.get(root);
    if (null != originNodeCopy) {
      return originNodeCopy;
    }
    NodeCopy nodeCopy = new NodeCopy(root.val);
    map.put(root, nodeCopy);
    nodeCopy.left = copyRandomBinaryTree(root.left);
    nodeCopy.right = copyRandomBinaryTree(root.right);
    nodeCopy.random = copyRandomBinaryTree(root.random);
    return nodeCopy;
  }

}