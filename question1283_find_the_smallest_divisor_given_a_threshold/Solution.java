package question1283_find_the_smallest_divisor_given_a_threshold;

public class Solution {

    public int smallestDivisor(int[] nums, int threshold) {
        int left = 1, right = nums.length;
        while (left < right) {
            if (left + 1 == right) {
                if (check(nums, left, threshold)) {
                    return left;
                }
                return right;
            }
            int mid = left + ((right - left) >> 1);
            if (check(nums, mid, threshold)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    private static boolean check(int[] nums, int target, int threshold) {
        int result = 0;
        for (int num : nums) {
            result += num / target;
            if (num % target != 0) {
                result++;
            }
        }
        return result <= threshold;
    }

}