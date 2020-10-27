package question1161_maximum_level_sum_of_a_binary_tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 层序遍历。
 *
 * 执行用时：9ms，击败80.05%。消耗内存：41.8MB，击败64.10%。
 */
public class Solution {
    public int maxLevelSum(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int result = -1, maxSum = Integer.MIN_VALUE, level = 0;
        while (!queue.isEmpty()) {
            int qSize = queue.size();
            int sum = 0;
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
            level++;
            if (sum > maxSum) {
                maxSum = sum;
                result = level;
            }
        }
        return result;
    }
}