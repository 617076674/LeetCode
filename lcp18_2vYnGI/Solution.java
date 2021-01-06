package lcp18_2vYnGI;

import java.util.Arrays;

public class Solution {

    private static final int MOD = 1000000007;

    public int breakfastNumber(int[] staple, int[] drinks, int x) {
        Arrays.sort(drinks);
        int result = 0;
        for (int num : staple) {
            result += ceil(drinks, x - num) + 1;
            result %= MOD;
        }
        return result;
    }

    private int ceil(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = left + ((right - left) >> 1);
            if (nums[mid] == target) {
                left = mid + 1;
            } else if (nums[mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return right;
    }

}