package question0747_largest_number_at_least_twice_of_others;

/**
 * 暴力破解法。
 *
 * 时间复杂度是O(n)，其中n为nums数组的长度。空间复杂度是O(1)。
 *
 * 执行用时：1ms，击败99.75%。消耗内存：34.9MB，击败88.78%。
 */
public class Solution {
    public int dominantIndex(int[] nums) {
        int n = nums.length, maxIndex = 0;
        for (int i = 1; i < n; i++) {
            if (nums[i] > nums[maxIndex]) {
                maxIndex = i;
            }
        }
        for (int i = 0; i < n; i++) {
            if (i == maxIndex) {
                continue;
            }
            if (nums[maxIndex] < (nums[i] << 1)) {
                return -1;
            }
        }
        return maxIndex;
    }
}
