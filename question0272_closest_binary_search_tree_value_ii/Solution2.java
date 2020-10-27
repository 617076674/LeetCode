package question0272_closest_binary_search_tree_value_ii;

import java.util.ArrayList;
import java.util.List;

/**
 * 先找到和 target 最近的元素在中序遍历中的索引，再双指针向左向右遍历。
 *
 * 时间复杂度和空间复杂度均是 O(n)，其中 n 为树中的节点个数。
 *
 * 执行用时：2ms，击败62.68%。消耗内存：38.4MB，击败100.00%。
 */
public class Solution2 {

  private List<Integer> inOrder = new ArrayList<>();

  private int closestIndex;

  private Double gap = Double.MAX_VALUE;

  public List<Integer> closestKValues(TreeNode root, double target, int k) {
    List<Integer> list = new ArrayList<>();
    if (k == 0) {
      return list;
    }
    inOrderTraversal(root, target, k);
    list.add(inOrder.get(closestIndex));
    int left = closestIndex - 1, right = closestIndex + 1;
    while (list.size() < k) {
      if (left < 0) {
        list.add(inOrder.get(right++));
      } else if (right >= inOrder.size()) {
        list.add(inOrder.get(left--));
      } else if (Math.abs(inOrder.get(left) - target) > Math.abs(inOrder.get(right) - target)) {
        list.add(inOrder.get(right++));
      } else {
        list.add(inOrder.get(left--));
      }
    }
    return list;
  }

  private void inOrderTraversal(TreeNode root, double target, int k) {
    if (null == root || inOrder.size() - closestIndex > k) {
      return;
    }
    inOrderTraversal(root.left, target, k);
    if (Math.abs(target - root.val) < gap) {
      gap = Math.abs(target - root.val);
      closestIndex = inOrder.size();
    }
    inOrder.add(root.val);
    inOrderTraversal(root.right, target, k);
  }

}