package question0199_binary_tree_right_side_view;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 层序遍历的改进。由于我们要找的是每一层的最右边的节点，因此我们对于每层遍历先遍历其右子树再遍历左子树。那么，每层的第一个节点就是我们要找的。
 *
 * 时间复杂度和空间复杂度均是O(n)，其中n为二叉树中的节点个数。
 *
 * 执行用时：3ms，击败77.48%。消耗内存：36MB，击败40.00%。
 */
public class Solution2 {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (null == root) {
            return result;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode cur = queue.poll();
                if (i == 0) {
                    result.add(cur.val);
                }
                if (null != cur.right) {
                    queue.add(cur.right);
                }
                if (null != cur.left) {
                    queue.add(cur.left);
                }
            }
        }
        return result;
    }
}