package question0687;

/**
 * @author qianyihui
 * @date 2019-07-12
 *
 * 递归。
 *
 * 时间复杂度是O(n)，其中n为树中的节点个数。空间复杂度是O(h)，其中h是树的高度。
 *
 * 执行用时：6ms，击败83.12%。消耗内存：41MB，击败95.35%。
 */
public class Solution {
    private int result = 0;

    public int longestUnivaluePath(TreeNode root) {
        longestUnivaluePathFromRoot(root);
        return result;
    }

    /**
     * 寻找以root为起点的最长同值路径，注意该路径必须以root为起点！！！
     *
     * 对于这种情形：
     *           1--------该点并不是该路径的起点，因为其左右子树都是1，但是这种情况对于计算题目所要求的最长同值路径有用。
     *         ↙  ↘
     *        1     1
     *
     * 在这个函数的计算过程中顺带求出题目所要求的最长同值路径。
     */
    private int longestUnivaluePathFromRoot(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int temp = 0;
        int left = longestUnivaluePathFromRoot(root.left);
        int right = longestUnivaluePathFromRoot(root.right);
        //当左右子树均不为空，且其值均和root的值相同时，需要更新result的值，但是对于longestUnivaluePathFromRoot()函数的计算没有作用
        if (root.left != null && root.right != null && root.val == root.left.val && root.val == root.right.val) {
            result = Math.max(result, 2 + left + right);
        }
        //只有当其左子树不为空，且其左孩子的值和root的值相同时，其左边才有一条以root为起点的路径！
        if (root.left != null && root.left.val == root.val) {
            temp = left + 1;
        }
        //只有当其右子树不为空，且其右孩子的值和root的值相同时，其右边才有一条以root为起点的路径！
        if (root.right != null && root.right.val == root.val) {
            temp = Math.max(temp, right + 1);
        }
        result = Math.max(result, temp);
        return temp;
    }
}
