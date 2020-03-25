package question0523_continuous_subarray_sum;

/**
 * 暴力破解法。
 *
 * 时间复杂度是O(n ^ 2)，其中n为nums数组的长度。空间复杂度是O(n)。
 *
 * 执行用时：23ms，击败42.60%。消耗内存：42.9MB，击败5.71%。
 */
public class Solution1 {
    public boolean checkSubarraySum(int[] nums, int k) {
        int n;
        if (null == nums || (n = nums.length) == 0) {
            return k == 0;
        }
        int[] sum = new int[n];
        sum[0] = nums[0];
        for (int i = 1; i < n; i++) {
            sum[i] = sum[i - 1] + nums[i];
        }
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (k == 0) {
                    if (i == 0 && sum[j] == 0) {
                        return true;
                    } else if (i != 0 && sum[j] - sum[i - 1] == 0) {
                        return true;
                    }
                } else {
                    if (i == 0 && sum[j] % k == 0) {
                        return true;
                    } else if (i != 0 && (sum[j] - sum[i - 1]) % k == 0) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
}