package question0643_maximum_average_subarray_i;

/**
 * 前序和。
 *
 * 时间复杂度和空间复杂度均是O(n)，其中n为nums数组的长度。
 *
 * 执行用时：8ms，击败56.16%。消耗内存：41MB，击败91.74%。
 */
public class Solution {
    public double findMaxAverage(int[] nums, int k) {
        int n = nums.length;
        int[] sum = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            sum[i] = sum[i - 1] + nums[i - 1];
        }
        Double result = null;
        for (int i = 0; i <= n - k; i++) {
            //[i, i + k - 1]
            if (result == null) {
                result = (sum[i + k] - sum[i]) * 1.0 / k;
            } else {
                result = Math.max(result, (sum[i + k] - sum[i]) * 1.0 / k);
            }
        }
        return result;
    }
}
