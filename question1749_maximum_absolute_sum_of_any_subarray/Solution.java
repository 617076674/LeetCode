package question1749_maximum_absolute_sum_of_any_subarray;

public class Solution {

    public int maxAbsoluteSum(int[] nums) {
        int result = 0, max = 0, min = 0;
        for (int num : nums) {
            max = Math.max(max + num, num);
            min = Math.min(min + num, num);
            result = Math.max(result, Math.max(Math.abs(max), Math.abs(min)));
        }
        return result;
    }

}