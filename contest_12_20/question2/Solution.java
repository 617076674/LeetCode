package contest_12_20.question2;

import java.util.HashMap;
import java.util.Map;

class Solution {
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

    public static void main(String[] args) {
        int[] nums = new int[] {4,2,4,5,6};
        System.out.println(new Solution().maximumUniqueSubarray(nums));
        nums = new int[] {1,1,1,1,1};
        System.out.println(new Solution().maximumUniqueSubarray(nums));
    }
}