package question128;

import java.util.HashMap;

public class Solution {
    public int longestConsecutive(int[] nums) {
        int result = 0;
        HashMap<Integer, Boolean> calculatedMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            calculatedMap.put(nums[i], false);  //初始时刻所有数均未被考虑过
        }
        for (int i = 0; i < nums.length; i++) {
            if (calculatedMap.get(nums[i])) { //如果nums[i]已经被考虑过了，跳过本次循环
                continue;
            }
            int left = nums[i] - 1;
            while (calculatedMap.containsKey(left) && !calculatedMap.get(left) && left >= Integer.MIN_VALUE) {
                calculatedMap.put(left, true);
                left--;
            }
            int right = nums[i] + 1;
            while (calculatedMap.containsKey(right) && !calculatedMap.get(right) && right <= Integer.MAX_VALUE) {
                calculatedMap.put(right, true);
                right++;
            }
            result = Math.max(result, right - left - 1);
        }
        return result;
    }
}
