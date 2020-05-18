package question0152_maximum_product_subarray;

/**
 * 如果 nums 数组中没有 0，该如何求最大值呢？
 *
 * 如果 nums 数组中的负数个数为偶数个，那么其最大值就是所有数字的乘积。
 *
 * 如果 nums 数组中的负数个数为奇数个，那么其最大值有两种可能：剔除第一个负数或最后一个负数，其余连续数字的乘积。
 *
 * 如果 nums 数组中有 0，怎么办呢？只需要将 nums 数组根据其中的 0 来分成若干份，每一份按照上述算法来计算即可。
 *
 * 时间复杂度和空间复杂度均是 O(n)，其中 n 为 nums 数组的长度。
 *
 * 执行用时：1ms，击败98.15%。消耗内存：39.6MB，击败6.67%。
 */
public class Solution4 {
    public int maxProduct(int[] nums) {
        int n = nums.length, left = -1, result = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            if (nums[i] == 0) {
                result = Math.max(result, 0);
                if (left + 1 <= i - 1) {
                    result = Math.max(result, maxProduct(nums, left + 1, i - 1));
                }
                left = i;
            }
        }
        if (left + 1 <= n - 1) {
            result = Math.max(result, maxProduct(nums, left + 1, n - 1));
        }
        return result;
    }

    private int maxProduct(int[] nums, int left, int right) {
        if (left == right) {
            return nums[left];
        }
        int n = right - left + 1, countNegative = 0, firstNegative = -1, lastNegative = -1;
        int[] multiple = new int[n + 1];
        multiple[0] = 1;
        for (int i = left; i <= right; i++) {
            multiple[i + 1 - left] = multiple[i - left] * nums[i];
            if (nums[i] < 0) {
                countNegative++;
                if (firstNegative == -1) {
                    firstNegative = i;
                }
                lastNegative = i;
            }
        }
        if ((countNegative & 1) == 0) {
            return multiple[n];
        }
        return Math.max(multiple[lastNegative - left], multiple[n] / multiple[firstNegative + 1 - left]);
    }
}