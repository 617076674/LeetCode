package question1218_longest_arithmetic_subsequence_of_given_difference;

import java.util.HashMap;
import java.util.Map;

/**
 * 状态压缩。
 *
 * 时间复杂度和空间复杂度均是 O(n)，其中 n 为 arr 数组的长度。
 *
 * 执行用时：48ms，击败57.89%。消耗内存：56.8MB，击败25.00%。
 */
public class Solution2 {
    public int longestSubsequence(int[] arr, int difference) {
        int result = 1;
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : arr) {
            int tmp = map.getOrDefault(num - difference, 0) + 1;
            result = Math.max(result, tmp);
            map.put(num, tmp);
        }
        return result;
    }
}