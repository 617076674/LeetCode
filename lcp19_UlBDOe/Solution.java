package lcp19_UlBDOe;

import java.util.Arrays;

/**
 * 动态规划。
 *
 * 状态定义：
 * dp[i][j] 表示对 leaves 中 [0, i] 范围内的子串进行调整，第 i 个字符的状态是 j，所需的最少操作次数。
 *
 * 时间复杂度和空间复杂度均是 O(n)，其中 n 为 leaves 的长度。
 *
 * 执行用时：339ms，击败5.14%。消耗内存：75.4MB，击败5.07%。
 */
public class Solution {

    private int[][] memo;

    public int minimumOperations(String leaves) {
        memo = new int[leaves.length()][3];
        for (int i = 0; i < leaves.length(); i++) {
            Arrays.fill(memo[i], -1);
        }
        return minimumOperations(leaves, leaves.length() - 1, 2);
    }

    private int minimumOperations(String leaves, int right, int status) {
        if (right == 0) {
            if (status == 0) {
                if (leaves.charAt(right) == 'r') {
                    return 0;
                }
                return 1;
            }
            return leaves.length();
        }
        if (memo[right][status] != -1) {
            return memo[right][status];
        }
        int result;
        if (status == 0) {
            result = minimumOperations(leaves, right - 1, 0);
            if (leaves.charAt(right) == 'y') {
                result++;
            }
        } else if (status == 1) {
            result = Math.min(minimumOperations(leaves, right - 1, 0), minimumOperations(leaves, right - 1, 1));
            if (leaves.charAt(right) == 'r') {
                result++;
            }
        } else {
            result = Math.min(minimumOperations(leaves, right - 1, 1), minimumOperations(leaves, right - 1, 2));
            if (leaves.charAt(right) == 'y') {
                result++;
            }
        }
        memo[right][status] = result;
        return result;
    }

}