package question0671;

/**
 * @author qianyihui
 * @date 2019-07-11
 *
 * 深度优先遍历算法。只要寻找到不等于min的节点就可以返回了！！！。
 *
 * 注意更新result值的过程，如果result为-1，即还没有找到第二小的节点，则将result直接置为当前节点的值。
 * 否则，result需要取result和当前节点值中的较小值。
 *
 * 时间复杂度是O(n)，其中n为树中的节点个数。空间复杂度是O(h)，其中h是树的高度。
 *
 * 执行用时：1ms，击败78.43%。消耗内存：34.1MB，击败72.92%。
 */
public class Solution {
    private int min;

    private int result = -1;

    public int findSecondMinimumValue(TreeNode root) {
        if (root == null) {
            return -1;
        }
        min = root.val;
        dfs(root.left);
        dfs(root.right);
        return result;
    }

    private void dfs(TreeNode treeNode) {
        if (treeNode == null) {
            return;
        }
        if (treeNode.val != min) {
            if (result == -1) {
                result = treeNode.val;
            } else {
                result = Math.min(treeNode.val, result);
            }
            return;
        }
        dfs(treeNode.left);
        dfs(treeNode.right);
    }
}
