package question1130_minimum_cost_tree_from_leaf_values;

/**
 * 记忆化搜索。
 *
 * 时间复杂度是 O(n ^ 3)。空间复杂度是 O(n ^ 2)，其中 n 为数组 arr 的长度。
 *
 * 执行用时：4ms，击败66.24%。消耗内存：37.8MB，击败100.00%。
 */
public class Solution1 {
    private int[][] memo, max;

    public int mctFromLeafValues(int[] arr) {
        int n = arr.length;
        memo = new int[n][n];
        max = new int[n][n];
        for (int i = 0; i < n; i++) {
            max[i][i] = arr[i];
            for (int j = i + 1; j < n; j++) {
                max[i][j] = Math.max(max[i][j - 1], arr[j]);
            }
        }
        return mctFromLeafValues(arr, 0, n - 1);
    }

    private int mctFromLeafValues(int[] arr, int left, int right) {
        if (left == right) {
            return 0;
        }
        if (memo[left][right] != 0) {
            return memo[left][right];
        }
        int result = Integer.MAX_VALUE;
        for (int i = left; i < right; i++) {
            result = Math.min(result, mctFromLeafValues(arr, left, i) + mctFromLeafValues(arr, i + 1, right) + max[left][i] * max[i + 1][right]);
        }
        memo[left][right] = result;
        return result;
    }
}