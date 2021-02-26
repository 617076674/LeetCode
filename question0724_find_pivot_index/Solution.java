package question0724_find_pivot_index;

/**
 * 前缀和。
 *
 * 时间复杂度和空间复杂度均是O(n)，其中n为nums数组的长度。
 *
 * 执行用时：2ms，击败99.91%。消耗内存：39.4MB，击败96.53%。
 */
public class Solution {

    public int pivotIndex(int[] nums) {
        int n;
        if (null == nums || (n = nums.length) == 0) {
            return -1;
        }
        int[] sum = new int[n + 1]; //sum[i]代表nums数组中[0, i - 1]的和
        for (int i = 1; i <= n; i++) {
            sum[i] = sum[i - 1] + nums[i - 1];
        }
        for (int center = 0; center < n; center++) {
            if (sum[center] == sum[n] - sum[center + 1]) {
                return center;
            }
        }
        return -1;
    }

}