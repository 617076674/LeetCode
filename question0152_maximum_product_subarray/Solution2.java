package question0152_maximum_product_subarray;

/**
 * 动态规划。
 *
 * 状态定义：
 * maxdp[i] 表示 nums 数组中以索引 i 处元素结尾的子数组的最大值。
 * mindp[i] 表示 nums 数组中以索引 j 处元素结尾的子数组的最小值。
 *
 * 初始化条件：
 * maxdp[i] = mindp[i] = nums[0]
 *
 * 状态转移方程：
 * （1）当 nums[i] >= 0 时，
 * maxdp[i] = max(maxdp[i - 1] * nums[i], nums[i]), mindp[i] = Math.min(mindp[i - 1] * nums[i], nums[i])。
 *
 * （2）当 nums[i] < 0 时，
 * maxdp[i] = Math.max(mindp[i - 1] * nums[i], nums[i]), mindp[i] = Math.min(maxdp[i - 1] * nums[i], nums[i])。
 *
 * 时间复杂度和空间复杂度均是 O(n)，其中 n 为 nums 数组的长度。
 *
 * 执行用时：2ms，击败92.58%。消耗内存：39.6MB，击败6.67%。
 */
public class Solution2 {
    public int maxProduct(int[] nums) {
        int n = nums.length, result = nums[0];
        int[] maxdp = new int[n], mindp = new int[n];
        maxdp[0] = mindp[0] = nums[0];
        for (int i = 1; i < n; i++) {
            if (nums[i] >= 0) {
                maxdp[i] = Math.max(maxdp[i - 1] * nums[i], nums[i]);
                mindp[i] = Math.min(mindp[i - 1] * nums[i], nums[i]);
            } else {
                maxdp[i] = Math.max(mindp[i - 1] * nums[i], nums[i]);
                mindp[i] = Math.min(maxdp[i - 1] * nums[i], nums[i]);
            }
            result = Math.max(result, maxdp[i]);
        }
        return result;
    }
}