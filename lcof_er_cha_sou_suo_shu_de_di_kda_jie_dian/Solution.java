package lcof_er_cha_sou_suo_shu_de_di_kda_jie_dian;

/**
 * 时间复杂度和空间复杂度均是O(n)，其中n为树中的节点个数。
 *
 * 执行用时：0ms，击败100.00%。消耗内存：39.3MB，击败100.00%。
 */
public class Solution {
    private int k;

    private Integer result;

    public int kthLargest(TreeNode root, int k) {
        this.k = k;
        inOrderTraversal(root);
        return result;
    }

    private void inOrderTraversal(TreeNode treeNode) {
        if (null == treeNode || null != result) {
            return;
        }
        inOrderTraversal(treeNode.right);
        if (--k == 0) {
            result = treeNode.val;
        }
        inOrderTraversal(treeNode.left);
    }
}