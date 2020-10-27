package question1110_delete_nodes_and_return_forest;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 后续遍历。
 *
 * 执行用时：1ms，击败100.00%。消耗内存：39.3MB，击败78.49%。
 */
public class Solution {

    private Set<Integer> deletedSet = new HashSet<>();

    private List<TreeNode> result = new ArrayList<>();

    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        for (int num : to_delete) {
            deletedSet.add(num);
        }
        if (null != root && !deletedSet.contains(root.val)) {
            result.add(root);
        }
        delNodes(root, null, 0);
        return result;
    }

    private void delNodes(TreeNode now, TreeNode parent, int direction) {
        if (null == now) {
            return;
        }
        delNodes(now.left, now, -1);
        delNodes(now.right, now, 1);
        if (deletedSet.contains(now.val)) {
            if (null != now.left) {
                result.add(now.left);
            }
            if (null != now.right) {
                result.add(now.right);
            }
            if (direction == -1) {
                parent.left = null;
            }
            if (direction == 1) {
                parent.right = null;
            }
        }
    }

}