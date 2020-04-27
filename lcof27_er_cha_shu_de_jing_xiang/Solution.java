package lcof27_er_cha_shu_de_jing_xiang;

/**
 * 执行用时：0ms，击败100.00%。消耗内存：37.3MB，击败100.00%。
 */
public class Solution {
    public TreeNode mirrorTree(TreeNode root) {
        if (null == root) {
            return root;
        }
        TreeNode left = root.left, right = root.right;
        root.left = mirrorTree(right);
        root.right = mirrorTree(left);
        return root;
    }
}