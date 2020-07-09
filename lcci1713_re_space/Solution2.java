package lcci1713_re_space;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * 动态规划。
 *
 * 状态定义：
 * dp[i] 表示 sentence 中 [i, sentence.length()) 范围内的子串断开后剩余的最少字符数量。
 *
 * 初始化条件：
 * dp[sentence.length()] = 0。
 *
 * 状态转移方程：
 * 如果 set.contains(sentence.substring(i, j))，那么 dp[i] = min(dp[i], dp[j])。
 * 否则，dp[i] = min(dp[i], j - i + dp[j])。
 *
 * 时间复杂度是 O(n ^ 2)，其中 n 为 sentence 的长度。空间复杂度是 O(n)。
 *
 * 执行用时：839ms，击败26.46%。消耗内存：40.8MB，击败100.00%。
 */
public class Solution2 {
    public int respace(String[] dictionary, String sentence) {
        Set<String> set = new HashSet<>(Arrays.asList(dictionary));
        int[] dp = new int[sentence.length() + 1];
        for (int i = sentence.length() - 1; i >= 0; i--) {
            dp[i] = Integer.MAX_VALUE;
            for (int j = i + 1; j <= sentence.length(); j++) {
                if (set.contains(sentence.substring(i, j))) {
                    dp[i] = Math.min(dp[i], dp[j]);
                } else {
                    dp[i] = Math.min(dp[i], j - i + dp[j]);
                }
            }
        }
        return dp[0];
    }
}