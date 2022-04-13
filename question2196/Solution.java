package question2196;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Solution {

  public TreeNode createBinaryTree(int[][] descriptions) {
    Map<Integer, TreeNode> id2Node = new HashMap<>();
    Set<Integer> canNotRootValues = new HashSet<>();
    for (int[] description : descriptions) {
      int parent = description[0];
      int child = description[1];
      TreeNode parentNode = id2Node.get(parent);
      if (null == parentNode) {
        parentNode = new TreeNode(parent);
        id2Node.put(parent, parentNode);
      }
      TreeNode childNode = id2Node.get(child);
      if (null == childNode) {
        childNode = new TreeNode(child);
        id2Node.put(child, childNode);
      }
      if (description[2] == 1) {
        parentNode.left = childNode;
      } else {
        parentNode.right = childNode;
      }
      canNotRootValues.add(child);
    }
    for (Map.Entry<Integer, TreeNode> entry : id2Node.entrySet()) {
      if (!canNotRootValues.contains(entry.getKey())) {
        return entry.getValue();
      }
    }
    return null;
  }

}