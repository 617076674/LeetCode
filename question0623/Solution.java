package question0623;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author qianyihui
 * @date 2019-07-14
 *
 * 层序遍历找到第d - 1行即可。题目对d大于树深度的情况没有作考虑，因此代码中也没有考虑该情况。
 *
 * 经过测试，如果root为null，d为1，LeetCode测试结果会输出：Line 4: AssertionError。
 *
 * 时间复杂度和空间复杂度均是O(n)，其中n为[1, d - 1]层的节点总数。
 *
 * 执行用时：2ms，击败91.43%。消耗内存：40.2MB，击败71.43%。
 */
public class Solution {
    public TreeNode addOneRow(TreeNode root, int v, int d) {
        if (d == 1) {
            TreeNode newRoot = new TreeNode(v);
            newRoot.left = root;
            return newRoot;
        }
        List<TreeNode> level = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int qSize = queue.size();
            d--;
            for (int i = 0; i < qSize; i++) {
                TreeNode treeNode = queue.poll();
                if (d == 1) {
                    level.add(treeNode);
                } else {
                    if (null != treeNode.left) {
                        queue.add(treeNode.left);
                    }
                    if (null != treeNode.right) {
                        queue.add(treeNode.right);
                    }
                }
            }
        }
        for (TreeNode treeNode : level) {
            TreeNode left = treeNode.left, right = treeNode.right;
            treeNode.left = new TreeNode(v);
            treeNode.left.left = left;
            treeNode.right = new TreeNode(v);
            treeNode.right.right = right;
        }
        return root;
    }
}
