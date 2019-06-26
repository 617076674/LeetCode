package queston0998;

/**
 * @author qianyihui
 * @date 2019-06-12
 * <p>
 * 题意不是非常明确。新插入节点时，始终往右子树中插入。
 * <p>
 * 时间复杂度和空间复杂度均是O(h)，其中h为二叉树的高度。
 * <p>
 * 执行用时：1ms，击败93.02%。消耗内存：34.3MB，击败93.10%。
 */
public class Solution {

    public TreeNode insertIntoMaxTree(TreeNode root, int val) {
        TreeNode treeNode = new TreeNode(val);
        if (val > root.val) {
            treeNode.left = root;
            return treeNode;
        }
        if (null == root.right) {
            root.right = treeNode;
        } else {
            root.right = insertIntoMaxTree(root.right, val);
        }
        return root;
    }

}
