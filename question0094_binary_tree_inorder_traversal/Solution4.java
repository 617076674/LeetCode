package question0094_binary_tree_inorder_traversal;

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
        if (null == root) {
            return list;
        }
        TreeNode cur = root;
        while (null != cur) {
            if (null == cur.left) {
                list.add(cur.val);
                cur = cur.right;
            } else {
                TreeNode prev = cur.left;
                while (null != prev.right && prev.right != cur) {
                    prev = prev.right;
                }
                if (null == prev.right) {
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