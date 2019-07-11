package question0662;

import java.util.ArrayList;
import java.util.List;

/**
 * @author qianyihui
 * @date 2019-07-11
 *
 * 联想堆，将所有的二叉树中的节点和一个数组中的索引对应起来，其中索引从1开始编号。
 * 对于某个节点i，其左孩子在数组中的索引是2i，其右孩子在数组中的索引是2 * i + 1。
 *
 * 时间复杂度是O(n)，其中n为树中的节点个数。空间复杂度是O(h)，其中h是树的高度。
 *
 * 执行用时：3ms，击败69.29%。消耗内存：35.7%，击败71.43%。
 */
public class Solution {
    private int result = 0;

    public int widthOfBinaryTree(TreeNode root) {
        dfs(root, 1, 1, new ArrayList<>());
        return result;
    }

    /**
     * 正在遍历树中的节点treeNode，该节点位于第level层，其索引值是index
     * left中保存的是每一层的最左端节点的索引值
     */
    private void dfs(TreeNode treeNode, int level, int index, List<Integer> left) {
        if (null == treeNode) {
            return;
        }
        if (level > left.size()) {
            left.add(index);
        }
        result = Math.max(result, index - left.get(level - 1) + 1);
        dfs(treeNode.left, level + 1, index * 2, left);
        dfs(treeNode.right, level + 1, index * 2 + 1, left);
    }
}
