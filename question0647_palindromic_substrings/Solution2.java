package question0647_palindromic_substrings;

/**
 * 动态规划。
 *
 * 状态定义：
 * dp[i][j] 表示字符串 s 中 [i, j] 范围内的子串是否是回文串。
 *
 * 初始化条件：
 * 当 i == j 时，dp[i][j] = true。
 *
 * 状态转移方程：
 * 当 s.charAt(i) == s.charAt(j) 时，如果 i - j == -1 或者 dp[i + 1][j - 1] = true，则 dp[i][j] = true。
 * 当 s.charAt(i) == s.charAt(j) 时，dp[i][j] = false。
 *
 * 时间复杂度和空间复杂度均是 O(n ^ 2)，其中 n 为字符串 s 的长度。
 *
 * 执行用时：17ms，击败20.07%。消耗内存：39.9MB，击败29.33%。
 */
public class Solution2 {
    public int countSubstrings(String s) {
        int count = 0, n = s.length();
        boolean[][] dp = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            dp[i][i] = true;
            count++;
        }
        for (int gap = -1; gap >= 1 - n; gap--) {
            for (int i = 0; i < n + gap; i++) {
                int j = i - gap;
                if (s.charAt(i) == s.charAt(j)) {
                    if (gap == -1 || dp[i + 1][j - 1]) {
                        dp[i][i - gap] = true;
                        count++;
                    }
                }
            }
        }
        return count;
    }
}