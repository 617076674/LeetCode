package question0094;

import java.util.ArrayList;
import java.util.List;

/**
 * Morris中序遍历。
 *
 * 时间复杂度是O(n)，其中n为二叉树中的节点个数。空间复杂度是O(1)，其中h为二叉树的高度。
 *
 * 执行用时：1ms，击败99.01%。消耗内存：35.2MB，击败39.36%。
 */
public class Solution4 {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if (root == null) {
            return list;
        }
        TreeNode cur = root;
        while (cur != null) {
            if (cur.left == null) {
                list.add(cur.val);
                cur = cur.right;
            } else {
                TreeNode prev = cur.left;
                while (prev.right != null && prev.right != cur) {
                    prev = prev.right;
                }
                if (prev.right == null) {
                    prev.right = cur;
                    cur = cur.left;
                } else {
                    prev.right = null;
                    list.add(cur.val);
                    cur = cur.right;
                }
            }
        }
        return list;
    }
}
