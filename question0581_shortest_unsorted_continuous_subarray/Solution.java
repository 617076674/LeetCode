package question0581_shortest_unsorted_continuous_subarray;

import java.util.Arrays;

public class Solution {
    
    public int findUnsortedSubarray(int[] nums) {
        int n = nums.length;
        int[] copy = new int[n];
        System.arraycopy(nums, 0, copy, 0, n);
        Arrays.sort(nums);
        int left = 0, right = n - 1;
        for (; left < n; left++) {
            if (copy[left] != nums[left]) {
                break;
            }
        }
        if (left == n) {
            return 0;
        }
        for (; right >= 0; right--) {
            if (copy[right] != nums[right]) {
                break;
            }
        }
        return right - left + 1;
    }

}