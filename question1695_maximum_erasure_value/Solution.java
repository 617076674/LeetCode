package question1695_maximum_erasure_value;

import java.util.HashMap;
import java.util.Map;

public class Solution {

    public int maximumUniqueSubarray(int[] nums) {
        int left = 0, right = -1;
        Map<Integer, Integer> map = new HashMap<>();
        int result = Integer.MIN_VALUE;
        int sum = 0;
        while (left < nums.length) {
            if (right + 1 < nums.length) {
                right++;
                sum += nums[right];
            }
            Integer last = map.get(nums[right]);
            if (null == last) {
                result = Math.max(result, sum);
            } else {
                while (left <= last) {
                    sum -= nums[left];
                    map.remove(nums[left]);
                    left++;
                }
            }
            map.put(nums[right], right);
        }
        return result;
    }

}