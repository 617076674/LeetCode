package question0159_longest_substring_with_at_most_two_distinct_characters;

/**
 * 动态规划。
 *
 * 状态定义：
 * dp[i]------以索引i处字符结尾的满足题意的最长子串的长度。
 *
 * 初始条件：
 * dp[0] = 1
 * dp[1] = 2
 *
 * 状态转移：
 * 如果说第i个字符和第(i-1)个字符相同，或者第i个字符和第(i-1-count[i-1])个字符相同，那么dp[i] = dp[i - 1] + 1。
 * 否则，dp[i] = 1 + count[i - 1]。
 * 其中count[i]表示从索引i处字符往前数（包括索引i处的字符），共有多少个字符是与索引i处字符相同的。
 *
 * 时间复杂度和空间复杂度均是O(n)，其中n为字符串s的长度。
 *
 * 执行用时：2ms，击败98.24%。消耗内存：36.3MB，击败100.00%。
 */
public class Solution {
    public int lengthOfLongestSubstringTwoDistinct(String s) {
        int n;
        if (null == s || (n = s.length()) == 0) {
            return 0;
        }
        if (n <= 2) {
            return n;
        }
        int[] count = new int[n];   //count[i]从索引i处字符往前数（包括索引i处的字符），共有多少个字符是与索引i处字符相同的
        count[0] = 1;
        for (int i = 1; i < n - 1; i++) {
            if (s.charAt(i) == s.charAt(i - 1)) {
                count[i] = count[i - 1] + 1;
            } else {
                count[i] = 1;
            }
        }
        int[] dp = new int[n];  //dp[i]表示以索引为i处字符结尾的满足题意的最长子串的长度
        dp[0] = 1;
        dp[1] = 2;
        int result = 2;
        for (int i = 2; i < n; i++) {
            if (s.charAt(i) == s.charAt(i - 1) || (i - 1 - count[i - 1] >= 0 && s.charAt(i) == s.charAt(i - 1 - count[i - 1]))) {
                dp[i] = dp[i - 1] + 1;
            } else {
                dp[i] = 1 + count[i - 1];
            }
            result = Math.max(result, dp[i]);
        }
        return result;
    }
}