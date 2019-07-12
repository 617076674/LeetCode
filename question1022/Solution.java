package question1022;

/**
 * @author qianyihui
 * @date 2019-07-12
 *
 * 时间复杂度是O(n)，其中n是树中的节点数。空间复杂度是O(h)，其中h是树的高度。
 *
 * 执行用时：1ms，击败98.55%。消耗内存：35.6MB，击败99.23%。
 */
public class Solution {
    public int sumRootToLeaf(TreeNode root) {
        return sumRootToLeaf(root, 0);
    }

    /**
     * 当前值是val，计算以root为子树的二进制和。
     */
    private int sumRootToLeaf(TreeNode root, int val) {
        if (root == null) {
            return 0;
        }
        val = (val << 1);    //利用左移运算代替乘法运算
        val |= root.val;     //注意，val的最低位一定是0，所以这里采用与root的值作或运算的操作
        if (null == root.left && null == root.right) {
            return val;
        }
        return sumRootToLeaf(root.left, val) + sumRootToLeaf(root.right, val);
    }
}
