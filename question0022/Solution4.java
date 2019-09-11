package question0022;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 动态规划。
 *
 * 状态定义：
 * dp[i]:i对括号能生成的有效的括号组合。
 *
 * 初始化条件：
 * dp[0]中只含有一个空字符串——""。
 *
 * 状态转移：
 * dp[i] = "(" + dp[j]中的字符串 + ")" + dp[i - j - 1]中的字符串
 *
 * 时间复杂度和空间复杂度的计算比较复杂，略。
 *
 * 执行用时：3ms，击败87.02%。消耗内存：37.4MB，击败86.88%。
 */
public class Solution4 {
    public List<String> generateParenthesis(int n) {
        List[] dp = new List[n + 1];
        for (int i = 0; i < n + 1; i++) {
            dp[i] = new ArrayList();
        }
        dp[0].add("");
        for (int i = 1; i < n + 1; i++) {
            for (int j = 0; j < i; j++) {
                List<String> list1 = dp[j], list2 = dp[i - j - 1];
                for (String s1 : list1) {
                    for (String s2 : list2) {
                        //写成这样也是可以的：list.add(s1 + "(" + s2 + ")");
                        dp[i].add("(" + s1 + ")" + s2);
                    }
                }
            }
        }
        return dp[n];
    }
}
