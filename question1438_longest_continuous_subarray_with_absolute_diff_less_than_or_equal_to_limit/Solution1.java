package question1438_longest_continuous_subarray_with_absolute_diff_less_than_or_equal_to_limit;

import java.util.TreeMap;

public class Solution1 {

    public int longestSubarray(int[] nums, int limit) {
        int result = 0, left = 0, right = -1;
        TreeMap<Integer, Integer> window = new TreeMap<>();
        while (right + 1 < nums.length) {
            right++;
            window.put(nums[right], window.getOrDefault(nums[right], 0) + 1);
            while (window.lastKey() - window.firstKey() > limit) {
                int origin = window.get(nums[left]);
                if (origin == 1) {
                    window.remove(nums[left]);
                } else {
                    window.put(nums[left], origin - 1);
                }
                left++;
            }
            result = Math.max(result, right - left + 1);
        }
        return result;
    }

}