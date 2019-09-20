package question0453;

/**
 * n-1个数加1，相当于1个数减1。
 *
 * 时间复杂度是O(n)，其中n为nums数组的长度。空间复杂度是O(1)。
 *
 * 执行用时：3ms，击败99.53%。消耗内存：39.1MB，击败92.70%。
 */
public class Solution {
    public int minMoves(int[] nums) {
        int n;
        if (null == nums || (n = nums.length) == 0 || n == 1) {
            return 0;
        }
        long sum = 0, min = Long.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            sum += nums[i];
            min = Math.min(min, nums[i]);
        }
        return (int) (sum - min * n);
    }
}
