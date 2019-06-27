package question0572;

/**
 * @author qianyihui
 * @date 2019-06-27
 *
 * 递归实现。
 *
 * 时间复杂度是O(mn)，其中m为s中的节点个数，n为t中的节点个数。
 *
 * 执行用时：17ms，击败43.43%。消耗内存：42.1MB，击败75.68%。
 */
public class Solution {
    public boolean isSubtree(TreeNode s, TreeNode t) {
        //这个初始判断很重要。虽然题目规定了输入的两棵二叉树均为非空二叉树
        //但是，在递归调用的过程中可能会出现s为null的情况
        if (null == s && null != t) {
            return false;
        }
        if (isSame(s, t)) {
            return true;
        }
        if (isSubtree(s.left, t)) {
            return true;
        }
        if (isSubtree(s.right, t)) {
            return true;
        }
        return false;
    }

    /**
     * 判断两棵二叉树是否完全相同。
     */
    public boolean isSame(TreeNode node1, TreeNode node2) {
        if (node1 == null && node2 == null) {
            return true;
        }
        if (node1 == null && node2 != null) {
            return false;
        }
        if (node1 != null && node2 == null) {
            return false;
        }
        if (node1.val != node2.val) {
            return false;
        }
        return isSame(node1.left, node2.left) && isSame(node1.right, node2.right);
    }
}
