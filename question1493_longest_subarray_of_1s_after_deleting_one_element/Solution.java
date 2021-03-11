package question1493_longest_subarray_of_1s_after_deleting_one_element;

public class Solution {

    public int longestSubarray(int[] nums) {
        int left = 0, right = -1, window = 0, result = 0;
        while (right + 1 < nums.length) {
            right++;
            if (nums[right] == 0) {
                window++;
            }
            while (window > 1) {
                if (nums[left] == 0) {
                    window--;
                }
                left++;
            }
            result = Math.max(right - left, result);
        }
        return result;
    }

}