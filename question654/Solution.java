package question654;

/**
 * @author qianyihui
 * @date 2019-06-12
 *
 * 递归实现即可。递归函数的定义：TreeNode constructMaximumBinaryTree(int[] nums, int left, int right)
 *
 * 将数组nums中[left, right]范围内的数据构造成一棵最大二叉树。
 *
 * 首先遍历nums数组中[left, right]范围内的数据，获得最大值的索引max，那么nums[max]就是该最大二叉树的根节点。
 *
 * 再依次递归求解左子树和右子树。
 *
 * 递归出口是，当left > right时返回null。
 *
 * 时间复杂度是O(n ^ 2)，其中n为nums数组的长度。空间复杂度是O(n)。
 *
 * 执行用时：7ms，击败72.08%。消耗内存：48.1MB，击败41.98%。
 */
public class Solution {

    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return constructMaximumBinaryTree(nums, 0, nums.length - 1);
    }

    private TreeNode constructMaximumBinaryTree(int[] nums, int left, int right) {
        if (left > right) {
            return null;
        }
        int max = left;
        for (int i = left + 1; i <= right; i++) {
            if (nums[i] > nums[max]) {
                max = i;
            }
        }
        TreeNode treeNode = new TreeNode(nums[max]);
        treeNode.left = constructMaximumBinaryTree(nums, left, max - 1);
        treeNode.right = constructMaximumBinaryTree(nums, max + 1, right);
        return treeNode;
    }

}
