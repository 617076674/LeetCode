package question0139_word_break;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 动态规划。
 *
 * 状态定义：
 * dp[i] 表示字符串 s 中 [i, s.length() - 1] 范围内的子串能否由 wordDict 中的字符串构成。
 *
 * 初始化条件：
 * 如果 wordDict 中包含有字符串 s.substring(i)，则 dp[i] = true。
 *
 * 状态转移方程：
 * 如果 wordDict 中的字符串 word 和 s.substring(i, i + word.length()) 相等，且 dp[i + word.length()] 为 true，有 dp[i] = true。
 *
 * 执行用时：7ms，击败83.58%。消耗内存：39.3MB，击败8.00%。
 */
public class Solution2 {
    public boolean wordBreak(String s, List<String> wordDict) {
        boolean[] dp = new boolean[s.length()];
        Set<String> wordSet = new HashSet<>(wordDict);
        for (int i = dp.length - 1; i >= 0; i--) {
            if (wordSet.contains(s.substring(i))) {
                dp[i] = true;
            } else {
                for (String word : wordSet) {
                    if (i + word.length() <= s.length() && word.equals(s.substring(i, i + word.length()))
                            && dp[i + word.length()]) {
                        dp[i] = true;
                        break;
                    }
                }
            }
        }
        return dp[0];
    }
}