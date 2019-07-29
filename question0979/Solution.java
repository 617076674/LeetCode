package question0979;

/**
 * @author qianyihui
 * @date 2019-07-29
 *
 * 如果树的叶子仅包含0枚金币，那么我们需要从它的父亲节点移动一枚金币到这个叶子节点上。
 * 如果一个叶子节点包含4枚金币，那么我们需要将这个叶子节点中的3枚金币移动到别的地方去。
 * 对于一个叶子节点，需要移动到它中或需要从它移动到它的父亲中的金币数量为Math.abs(num_coins - 1)。
 * 在接下来的计算中，我们就再也不需要考虑这些已经考虑过的叶子节点了。
 *
 * 时间复杂度是O(n)，其中n为树中的节点个数。空间复杂度是O(h)，其中h为树的高度。
 *
 * 执行用时：2ms，击败81.56%。消耗内存：35.9MB，击败78.79%。
 */
public class Solution {
    private int result;

    public int distributeCoins(TreeNode root) {
        dfs(root);
        return result;
    }

    //dfs(node)为这个子树中金币的数量减去这个子树中节点的数量
    public int dfs(TreeNode node) {
        if (node == null) {
            return 0;
        }
        int leftResult = dfs(node.left);
        int rightResult = dfs(node.right);
        result += Math.abs(leftResult) + Math.abs(rightResult);
        return node.val + leftResult + rightResult - 1;
    }
}
