package question1498_number_of_subsequences_that_satisfy_the_given_sum_condition;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Solution {

    private static final int MOD = 1000000007;

    private Map<Integer, Long> memo = new HashMap<>();

    public int numSubseq(int[] nums, int target) {
        Arrays.sort(nums);
        int left = 0, right = nums.length - 1;
        long result = 0L;
        while (left <= right) {
            if (nums[left] + nums[right] > target) {
                right--;
            } else {
                result += pow(right - left);
                result %= MOD;
                left++;
            }
        }
        return (int) result;
    }

    private long pow(int times) {
        if (times == 0) {
            return 1;
        }
        Long result = memo.get(times);
        if (null != result) {
            return result;
        }
        result = 1L;
        long half = pow(times / 2);
        result *= half;
        result %= MOD;
        result *= half;
        result %= MOD;
        if ((times & 1) == 1) {
            result *= 2;
        }
        result %= MOD;
        memo.put(times, result);
        return result;
    }

    public static void main(String[] args) {
        int[] nums = {2,3,3,4,6,7};
        System.out.println(new Solution().numSubseq(nums, 12));
    }

}