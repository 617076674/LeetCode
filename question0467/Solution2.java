package question0467;

import java.util.Arrays;

/**
 * 动态规划。
 *
 * 状态定义：
 * dp[i]:以p.charAt(i)结尾的合法字符串的最大长度。
 *
 * 状态转移：
 * 当i == 0时，dp[i] = 1。
 * 当i > 0时，如果说(p.charAt(i) - p.charAt(i - 1) + 26) % 26 == 1)，则有dp[i] = dp[i - 1] + 1。
 *           否则，dp[i] = 1。
 *
 * 时间复杂度是O(n)，其中n为字符串p的长度。空间复杂度是O(1)。
 *
 * 执行用时：18ms，击败22.37%。消耗内存：40.1MB，击败57.14%。
 */
public class Solution2 {
    public int findSubstringInWraproundString(String p) {
        //count[0]表示以字符'a'结尾的最长子串的长度
        //count[1]表示以字符'b'结尾的最长子串的长度
        //......
        //count[25]表示以字符'z'结尾的最长子串的长度
        int[] count = new int[26];
        int n = p.length();
        int[] dp = new int[n];
        Arrays.fill(dp, 1);
        for (int i = 0; i < n; i++) {
            char c = p.charAt(i);
            if (i > 0 && (c - p.charAt(i - 1) + 26) % 26 == 1) {
                dp[i] = dp[i - 1] + 1;
            }
            count[c - 'a'] = Math.max(count[c - 'a'], dp[i]);
        }
        int result = 0;
        for (int i = 0; i < 26; i++) {
            result += count[i];
        }
        return result;
    }
}
