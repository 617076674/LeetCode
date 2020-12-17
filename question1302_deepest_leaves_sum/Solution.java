package question1302_deepest_leaves_sum;

import java.util.LinkedList;
import java.util.Queue;

public class Solution {
    public int deepestLeavesSum(TreeNode root) {
        if (null == root) {
            return 0;
        }
        int sum = 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int qSize = queue.size();
            sum = 0;
            for (int i = 0; i < qSize; i++) {
                TreeNode now = queue.poll();
                sum += now.val;
                if (null != now.left) {
                    queue.add(now.left);
                }
                if (null != now.right) {
                    queue.add(now.right);
                }
            }
        }
        return sum;
    }
}