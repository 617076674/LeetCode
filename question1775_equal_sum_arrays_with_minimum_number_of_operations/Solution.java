package question1775_equal_sum_arrays_with_minimum_number_of_operations;

public class Solution {

    public int minOperations(int[] nums1, int[] nums2) {
        if (6 * nums1.length < nums2.length || 6 * nums2.length < nums1.length) {
            return -1;
        }
        int[] map = new int[6];
        int sum1 = 0, sum2 = 0;
        for (int num1 : nums1) {
            map[6 - num1]++;
            sum1 += num1;
        }
        for (int num2 : nums2) {
            map[num2 - 1]++;
            sum2 += num2;
        }
        if (sum1 == sum2) {
            return 0;
        }
        if (sum1 < sum2) {
            int gap = sum2 - sum1, result = 0;
            for (int i = 5; i > 0 && gap > 0; i--) {
                while (map[i] > 0 && gap > 0) {
                    result++;
                    map[i]--;
                    gap -= i;
                }
            }
            return result;
        }
        return minOperations(nums2, nums1);
    }

}