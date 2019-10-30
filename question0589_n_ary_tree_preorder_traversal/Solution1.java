package question0589_n_ary_tree_preorder_traversal;

import java.util.ArrayList;
import java.util.List;

/**
 * 递归实现。和二叉树的前序遍历相同。
 *
 * 时间复杂度是O(n)，其中n为树中的节点个数。空间复杂度是O(h)，其中h为树的高度。
 *
 * 执行用时：2ms，击败81.07%。消耗内存：46.4MB，击败97.19%。
 */
public class Solution1 {
    private List<Integer> result = new ArrayList<>();

    public List<Integer> preorder(Node root) {
        preorderTraversal(root);
        return result;
    }

    private void preorderTraversal(Node root) {
        if (null == root) {
            return;
        }
        result.add(root.val);
        for (Node node : root.children) {
            preorderTraversal(node);
        }
    }
}