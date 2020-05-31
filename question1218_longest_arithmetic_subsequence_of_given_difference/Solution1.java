package question1218_longest_arithmetic_subsequence_of_given_difference;

import java.util.HashMap;
import java.util.Map;

/**
 * 动态规划 + 哈希表。
 *
 * 状态定义：
 * dp[i] 表示以 arr[i] 结尾的公差为 difference 的等差子序列的最大长度。
 *
 * 初始化条件：
 * dp[0] = 1。
 *
 * 状态转移方程：
 * dp[i] = max(1, dp[index] + 1), 其中 arr[index] + difference = arr[i]。
 *
 * 时间复杂度和空间复杂度均是 O(n)，其中 n 为 arr 数组的长度。
 *
 * 执行用时：51ms，击败49.84%。消耗内存：59.6MB，击败25.00%。
 */
public class Solution1 {
    public int longestSubsequence(int[] arr, int difference) {
        int[] dp = new int[arr.length];
        int result = 1;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < dp.length; i++) {
            dp[i] = 1;
            Integer index = map.get(arr[i] - difference);
            if (null != index) {
                dp[i] = Math.max(dp[i], index + 1);
            }
            result = Math.max(result, dp[i]);
            map.put(arr[i], dp[i]);
        }
        return result;
    }
}