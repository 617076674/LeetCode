package question0128_longest_consecutive_sequence;

import java.util.HashSet;
import java.util.Set;

/**
 * 哈希表。
 *
 * 时间复杂度和空间复杂度均是 O(n)，其中 n 为 nums 数组的长度。
 *
 * 执行用时：11ms，击败22.31%。消耗内存：40.5MB，击败8.33%。
 */
public class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>(), used = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        int result = 0;
        for (int num : nums) {
            if (!used.contains(num)) {
                int left = num - 1, right = num + 1;
                while (set.contains(left)) {
                    used.add(left);
                    left--;
                }
                while (set.contains(right)) {
                    used.add(right);
                    right++;
                }
                result = Math.max(result, right - left - 1);
            }
        }
        return result;
    }
}