package question0110_balanced_binary_tree;

import java.util.Objects;

/**
 * 递归实现。
 *
 * 时间复杂度是 O(n ^ 2)。空间复杂度是 O(n)。
 *
 * 执行用时：1ms，击败99.76%。消耗内存：39.7MB，击败88.68%。
 */
public class Solution2 {
    public boolean isBalanced(TreeNode root) {
        if (Objects.isNull(root)) {
            return true;
        }
        return Math.abs(getHeight(root.left) - getHeight(root.right)) <= 1 && isBalanced(root.left) && isBalanced(root.right);
    }
    
    private int getHeight(TreeNode root) {
        if (Objects.isNull(root)) {
            return 0;
        }
        return 1 + Math.max(getHeight(root.left), getHeight(root.right));
    }
}