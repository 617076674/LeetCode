package question0713;

/**
 * 双指针。
 *
 * 时间复杂度是O(n)，其中n为nums数组的长度。空间复杂度是O(1)。
 *
 * 执行用时：19ms，击败41.07%。消耗内存：65.1MB，击败61.11%。
 */
public class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        int n;
        if (null == nums || (n = nums.length) == 0) {
            return 0;
        }
        int left = 0, right = -1, result = 0, mutiply = 1;
        while (right + 1 < n) {
            right++;
            if (mutiply < k) {
                mutiply *= nums[right];
            }
            while (left + 1 < n && mutiply >= k) {
                mutiply /= nums[left];
                left++;
            }
            result += right - left + 1; //以right结尾的子数组有(right - left + 1)个
        }
        return result;
    }
}
