package lcof55_er_cha_shu_de_shen_du;

/**
 * 执行用时：0ms，击败100.00%。消耗内存：40MB，击败100.00%。
 */
public class Solution {
    public int maxDepth(TreeNode root) {
        if (null == root) {
            return 0;
        }
        return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
    }
}