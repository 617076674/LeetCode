package question096;

/**
 * 递归实现。
 *
 * 时间复杂度和空间复杂度均是O(n!)，其中n为树中的节点个数。
 *
 * 在LeetCode中提交会超时。
 */
public class Solution2 {
    public int numTrees(int n) {
        if (n == 1) {
            return 1;
        }
        int count = 0;
        for (int i = 1; i <= n; i++) {
            if (i == 1 || i == n) {
                count += numTrees(n - 1);
            } else {
                count += numTrees(i - 1) * numTrees(n - i);
            }
        }
        return count;
    }
}
