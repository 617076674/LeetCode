package question0128_longest_consecutive_sequence;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public int longestConsecutive(int[] nums) {
        if (null == nums || (nums.length) == 0) {
            return 0;
        }
        int result = 0;
        Map<Integer, Boolean> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, false);  //初始时刻所有数均未被考虑过
        }
        for (int num : nums) {
            if (map.get(num)) { //如果nums[i]已经被考虑过了，跳过本次循环
                continue;
            }
            int left = num - 1;
            while (map.containsKey(left) && !map.get(left)) {
                map.put(left, true);
                left--;
            }
            int right = num + 1;
            while (map.containsKey(right) && !map.get(right)) {
                map.put(right, true);
                right++;
            }
            result = Math.max(result, right - left - 1);
        }
        return result;
    }
}