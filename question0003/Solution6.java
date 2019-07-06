package question0003;

import java.util.Arrays;

/**
 * @author qianyihui
 * @date 2019-07-06
 *
 * 状态定义：f(x)，字符串s中以索引x处字符结尾的最长不含重复字符的子字符串长度。
 *
 * 状态转移：
 * （1）f(0) = 1
 * （2）如果第x个字符在之前未出现过，f(x) = f(x - 1) + 1
 * （3）如果第x个字符在之前索引y处出现过，如果(x - y) <= f(x - 1)，f(x) = x - y。否则f(x) = f(x - 1) + 1。
 *
 * 时间复杂度是O(n)，其中n为字符串s的长度。空间复杂度是O(1)。
 *
 * 执行用时：15ms，击败83.13%。消耗内存：38.5MB，击败87.46%。
 */
public class Solution6 {
    public int lengthOfLongestSubstring(String s) {
        if (s.length() == 0) {
            return 0;
        }
        int[] last = new int[256], dp = new int[s.length()];
        Arrays.fill(last, -1);
        dp[0] = 1;
        last[s.charAt(0)] = 0;
        for (int i = 1; i < s.length(); i++) {
            if (last[s.charAt(i)] == -1) {
                dp[i] = dp[i - 1] + 1;
            } else {
                if (i - last[s.charAt(i)] <= dp[i - 1]) {
                    dp[i] = i - last[s.charAt(i)];
                } else {
                    dp[i] = dp[i - 1] + 1;
                }
            }
            last[s.charAt(i)] = i;
        }
        int result = dp[0];
        for (int i = 1; i < dp.length; i++) {
            result = Math.max(dp[i], result);
        }
        return result;
    }
}
