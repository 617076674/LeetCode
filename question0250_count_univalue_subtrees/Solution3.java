package question0250_count_univalue_subtrees;

/**
 * https://leetcode-cn.com/problems/count-univalue-subtrees/
 *
 * 递归实现。
 *
 * 时间复杂度是O(n)，其中n为树中的节点个数。空间复杂度是O(h)，其中h为树的高度。
 *
 * 执行用时：0ms，击败100.00%。消耗内存：36.9MB，击败100.00%。
 */
public class Solution3 {
    private int count = 0;

    public int countUnivalSubtrees(TreeNode root) {
        //对于根节点root的父节点的值，设置为0，其实这个值可以任意设，因为我们不需要利用这个节点返回的布尔值
        isUniqueTree(root, 0);
        return count;
    }

    //检查当前节点是否是有效的子树，它返回一个布尔值，指示该节点是否为其父节点的有效组成。这可以通过传入父节点的值来完成。
    private boolean isUniqueTree(TreeNode node, int val) {
        if (null == node) {
            return true;
        }
        //注意这里的或条件的判断需要使用|，而不是||，||是短路与，不会全部计算前后两个条件，而|会前后计算两个条件
        if (!isUniqueTree(node.left, node.val) | !isUniqueTree(node.right, node.val)) {
            return false;
        }
        count++;
        return node.val == val;
    }
}