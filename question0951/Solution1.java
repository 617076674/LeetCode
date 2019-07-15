package question0951;

/**
 * @author qianyihui
 * @date 2019-07-15
 *
 * 递归实现。
 *
 * 时间复杂度是O(n)，其中n为两棵树中节点数的较小值。空间复杂度是O(h)，其中h为两棵树中高度的较小值。
 *
 * 执行用时：1ms，击败94.40%。消耗内存：35MB，击败83.33%。
 */
public class Solution1 {
    public boolean flipEquiv(TreeNode root1, TreeNode root2) {
        if (root1 == null && root2 == null) {
            return true;
        }
        if (root1 == null || root2 == null) {
            return false;
        }
        if (root1.val != root2.val) {
            return false;
        }
        return (flipEquiv(root1.left, root2.left) && flipEquiv(root1.right, root2.right))
                || (flipEquiv(root1.left, root2.right) && flipEquiv(root1.right, root2.left));
    }
}
