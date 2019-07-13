package question0098;

import java.util.ArrayList;
import java.util.List;

/**
 * 中序遍历，判断中序遍历序列是否是递增的。
 *
 * 时间复杂度和空间复杂度均是O(n)，其中n为树中的节点个数。
 *
 * 执行用时：3ms，击败44.13%。消耗内存：37.1MB，击败86.52%。
 */
public class Solution1 {
    private List<Integer> list = new ArrayList<>();

    public boolean isValidBST(TreeNode root) {
        inorderTraversal(root);
        for (int i = 1; i < list.size(); i++) {
            if (list.get(i) <= list.get(i - 1)) {
                return false;
            }
        }
        return true;
    }

    private void inorderTraversal(TreeNode root) {
        if (root == null) {
            return;
        }
        inorderTraversal(root.left);
        list.add(root.val);
        inorderTraversal(root.right);
    }
}
