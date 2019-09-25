package question0003_longest_substring_without_repeating_characters;

import java.util.Arrays;

/**
 * https://leetcode-cn.com/problems/longest-substring-without-repeating-characters/
 *
 * https://leetcode-cn.com/problems/longest-substring-without-repeating-characters/solution/wu-zhong-fu-zi-fu-de-zui-chang-zi-chuan-4chong-jie/
 *
 * 动态规划。
 *
 * 状态定义：
 * dp[x]:字符串s中以索引x处字符结尾的最长不含重复字符的子字符串长度。
 *
 * 状态转移：
 * （1）dp(0) = 1
 * （2）如果第x个字符在之前未出现过，dp[x] = dp[x - 1] + 1
 * （3）如果第x个字符在之前索引y处出现过，如果(x - y) <= dp[x - 1]，dp[x] = x - y。否则dp[x] = dp[x - 1] + 1
 *
 * 时间复杂度是O(n)，其中n为字符串s的长度。空间复杂度是O(1)。
 *
 * 执行用时：9ms，击败94.74%。消耗内存：37.9MB，击败90.45%。
 */
public class Solution4 {
    public int lengthOfLongestSubstring(String s) {
        int n;
        if (s == null || (n = s.length()) == 0) {
            return 0;
        }
        int[] last = new int[256];
        Arrays.fill(last, -1);
        int dp = 1;
        last[s.charAt(0)] = 0;
        int result = dp;
        for (int i = 1; i < n; i++) {
            char c = s.charAt(i);
            if (last[c] == -1) {
                dp++;
            } else {
                if (i - last[c] <= dp) {
                    dp = i - last[c];
                } else {
                    dp++;
                }
            }
            last[c] = i;
            result = Math.max(result, dp);
        }
        return result;
    }
}
