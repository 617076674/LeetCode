package question096;

/**
 * 和question0095同样的思路。递归解法。
 *
 * 时间复杂度和空间复杂度均是O(n!)，其中n为树中的节点个数。
 *
 * 在LeetCode中提交会超时。
 */
public class Solution1 {
    public int numTrees(int n) {
        return numTrees(1, n);
    }

    private int numTrees(int left, int right) {
        if (left == right) {
            return 1;
        }
        int count = 0;
        for (int i = left; i <= right; i++) {
            if (i == left) {
                count += numTrees(i + 1, right);
            } else if (i == right) {
                count += numTrees(left, i - 1);
            } else {
                count += numTrees(left, i - 1) * numTrees(i + 1, right);
            }
        }
        return count;
    }
}
