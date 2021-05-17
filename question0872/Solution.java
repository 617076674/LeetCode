package question0872;

import java.util.ArrayList;
import java.util.List;

/**
 * 前序遍历记录所有叶子节点即可。
 *
 * 时间复杂度和空间复杂度均为O(n)，其中n为root1和root2中的节点总数。
 *
 * 执行用时：1ms，击败99.58%。消耗内存：34.5MB，击败86.12%。
 */
public class Solution {

    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();
        preOrder(root1, list1);
        preOrder(root2, list2);
        if (list1.size() != list2.size()) {
            return false;
        }
        for (int i = 0; i < list1.size(); i++) {
            if (list1.get(i) - list2.get(i) != 0) {
                return false;
            }
        }
        return true;
    }

    private void preOrder(TreeNode treeNode, List<Integer> list) {
        if (null == treeNode) {
            return;
        }
        if (treeNode.left == null && treeNode.right == null) {
            list.add(treeNode.val);
        }
        preOrder(treeNode.left, list);
        preOrder(treeNode.right, list);
    }

}
