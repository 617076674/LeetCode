package question0129_sum_root_to_leaf_numbers;

/**
 * 递归。
 *
 * 执行用时：0ms，击败100.00%。消耗内存：35.8MB，击败97.18%。
 */
public class Solution {

    private int result;

    private int num;

    public int sumNumbers(TreeNode root) {
        if (null == root) {
            return 0;
        }
        dfs(root);
        return result;
    }

    private void dfs(TreeNode now) {
        if (now.left == null && now.right == null) {
            num = num * 10 + now.val;
            result += num;
            num /= 10;
            return;
        }
        num = num * 10 + now.val;
        if (null != now.left) {
            dfs(now.left);
        }
        if (null != now.right) {
            dfs(now.right);
        }
        num /= 10;
    }

}