package question0366;

import java.util.ArrayList;
import java.util.List;

/**
 * @author qianyihui
 * @date 2019-08-13
 *
 * 在递归寻找叶子节点的过程中，记录当前节点的父亲节点。
 *
 * 时间复杂度和空间复杂度均是O(n)，其中n为树中的节点个数。
 *
 * 执行用时：2ms，击败55.57%。消耗内存：35.9MB，击败100.00%。
 */
public class Solution {
    private List<Integer> list = new ArrayList<>();

    public List<List<Integer>> findLeaves(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (null == root) {
            return result;
        }
        while (root.left != null || root.right != null) {
            findLeaves(root, null);
            result.add(new ArrayList<>(list));
            list.clear();
        }
        //整棵树只剩下根节点
        list.add(root.val);
        result.add(list);
        return result;
    }

    //在root为根的树中寻找叶子节点加入list里，其中parent是root节点的父节点
    private void findLeaves(TreeNode root, TreeNode parent) {
        if (root == null) {
            return;
        }
        if (root.left == null && root.right == null) {
            list.add(root.val);
            // 删除当前叶子节点
            if (parent != null && parent.left == root) {
                parent.left = null;
            }
            if (parent != null && parent.right == root) {
                parent.right = null;
            }
        }
        findLeaves(root.left, root);
        findLeaves(root.right, root);
    }
}
