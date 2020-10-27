package question0272_closest_binary_search_tree_value_ii;

import java.util.ArrayList;
import java.util.List;

/**
 * 中序遍历。
 *
 * 时间复杂度是 O(nlogn)，其中 n 为树中的节点个数。空间复杂度是 O(n)。
 *
 * 执行用时：3ms，击败52.82%。消耗内存：38.4MB，击败100.00%。
 */
public class Solution1 {

    private List<Integer> inOrder = new ArrayList<>();

    public List<Integer> closestKValues(TreeNode root, double target, int k) {
        inOrderTraversal(root);
        inOrder.sort((num1, num2) -> {
            if (Math.abs(num1 - target) - Math.abs(num2 - target) < 0) {
                return -1;
            }
            return 1;
        });
        return inOrder.subList(0, k);
    }

    private void inOrderTraversal(TreeNode treeNode) {
        if (null == treeNode) {
            return;
        }
        inOrderTraversal(treeNode.left);
        inOrder.add(treeNode.val);
        inOrderTraversal(treeNode.right);
    }

}