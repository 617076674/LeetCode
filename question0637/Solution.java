package question0637;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author qianyihui
 * @date 2019-07-15
 *
 * 层序遍历。
 *
 * 时间复杂度和空间复杂度均是O(n)，其中n为树中的节点个数。
 *
 * 执行用时：6ms，击败69.34%。消耗内存：45MB，击败54.64%。
 */
public class Solution {
    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int qSize = queue.size();
            double sum = 0.0;   //一层中的节点和可能会超出int型的范围
            for (int i = 0; i < qSize; i++) {
                TreeNode treeNode = queue.poll();
                sum += treeNode.val;
                if (null != treeNode.left) {
                    queue.add(treeNode.left);
                }
                if (null != treeNode.right) {
                    queue.add(treeNode.right);
                }
            }
            result.add(sum / qSize);
        }
        return result;
    }

}
