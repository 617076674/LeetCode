package question0032_longest_valid_parentheses;

/**
 * https://leetcode-cn.com/problems/longest-valid-parentheses/
 *
 * 动态规划。
 *
 * 状态定义：
 * dp[i]表示以字符串s中第i个字符结尾的有效括号的最长子串的长度。
 *
 * 状态转移：
 * （1）如果s.charAt(i) == '('，显然有效括号是不可能以'('结尾的，因此dp[i] = 0。
 * （2）如果s.charAt(i) == ')'，
 * a.如果s.charAt(i - 1) == '('，说明第i - 1个字符'('和第x个字符')'相匹配，因此dp[i] = 2 + dp[i - 2]。
 * b.如果s.charAt(i - 1) == ')'，那么第i个字符')'该和谁去匹配呢？
 * 注意，此时dp[i - 1]表示以字符串s中第i - 1个字符结尾的有效括号的子串的最长长度，因此第i个字符')'应该和
 * 第i - dp[i - 1] - 1个字符去配对。如果s.charAt(i - dp[i - 1] - 1) == '('，那么
 * dp[i] = dp[i - 1] + 2 + dp[i - dp[i - 1] - 2] ，其中dp[i - dp[i - 1] - 2]代表的是以字符串s中
 * 第i - dp[i - 1] - 2个字符结尾的有效括号的最长子串的长度。
 *
 * 时间复杂度和空间复杂度均是O(n)，其中n为字符串s的长度。
 *
 * 执行用时：2ms，击败99.27%。消耗内存：35.9MB，击败95.05%。
 */
public class Solution2 {
    public int longestValidParentheses(String s) {
        int result = 0, n = s.length();
        int[] dp = new int[n];
        for (int i = 1; i < n; i++) {
            if (s.charAt(i) == ')') {
                if (s.charAt(i - 1) == '(') {
                    if (i >= 2) {
                        dp[i] = dp[i - 2] + 2;
                    } else {
                        dp[i] = 2;
                    }
                } else {
                    if (i - 1 - dp[i - 1] >= 0 && s.charAt(i - 1 - dp[i - 1]) == '(') {
                        if (i - 2 - dp[i - 1] >= 0) {
                            dp[i] = dp[i - 1] + dp[i - 2 - dp[i - 1]] + 2;
                        } else {
                            dp[i] = dp[i - 1] + 2;
                        }
                    }
                }
            }
            result = Math.max(result, dp[i]);
        }
        return result;
    }
}