package question0156;

/**
 * @author qianyihui
 * @date 2019-07-31
 *
 * 翻转要点：左子树递归变为根，右子树变为左子树，根变为右子树。
 *
 * 时间复杂度是O(n)，其中n为树中的节点个数。空间复杂度是O(h)，其中h是树的高度。
 *
 * 执行用时：1ms，击败100.00%。消耗内存：35.3MB，击败100.00%。
 */
public class Solution {
    public TreeNode upsideDownBinaryTree(TreeNode root) {
        if (null == root || root.left == null) {    //如果root.left == null，必然有root.right == null，即root没有孩子
            return root;
        }
        TreeNode newRoot = upsideDownBinaryTree(root.left); //左子树递归变为根
        root.left.left = root.right;    //右子树变为左子树
        root.left.right = root; //根变为右子树
        root.left = null;
        root.right = null;
        return newRoot;
    }
}
