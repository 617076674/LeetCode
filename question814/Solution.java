package question814;

/**
 * 在递归判断某树是否只包含0时，顺便将只包含0的节点裁剪掉。
 * <p>
 * 需要注意的是，LeetCode的测试用例里没有包含这样的测试：只有一个节点，该节点值是0。理论上来说这样的测试应该返回null。即移除整棵树。
 * <p>
 * 时间复杂度是O(n)，其中n为二叉树中的节点个数。空间复杂度是O(logh)，其中h为二叉树的高度。
 * <p>
 * 执行用时：1ms，击败81.30%。消耗内存：34.5MB，击败67.13%。
 */
public class Solution {

    public TreeNode pruneTree(TreeNode root) {
        if (onlyContains0(root)) {
            return null;
        }
        return root;
    }

    private boolean onlyContains0(TreeNode treeNode) {
        if (null == treeNode) {
            return true;
        }
        boolean left = onlyContains0(treeNode.left);
        boolean right = onlyContains0(treeNode.right);
        if (left) {
            treeNode.left = null;
        }
        if (right) {
            treeNode.right = null;
        }
        return treeNode.val == 0 && left && right;
    }

}
