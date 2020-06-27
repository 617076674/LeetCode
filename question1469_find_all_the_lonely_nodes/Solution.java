package question1469_find_all_the_lonely_nodes;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 层序遍历。
 *
 * 时间复杂度和空间复杂度均为 O(n)，其中 n 为树中的节点个数。
 *
 * 执行用时：4ms，击败13.73%。消耗内存：40.2MB，击败100.00%。
 */
public class Solution {
    public List<Integer> getLonelyNodes(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode now = queue.poll();
            if (now.left == null && now.right == null) {
                continue;
            }
            if (now.left == null || now.right == null) {
                if (now.left == null) {
                    result.add(now.right.val);
                } else {
                    result.add(now.left.val);
                }
            }
            if (now.left != null) {
                queue.add(now.left);
            }
            if (now.right != null) {
                queue.add(now.right);
            }
        }
        return result;
    }
}