package question0035;

/**
 * floor()函数的实现，寻找nums数组中值小于target的最大值所在的索引。
 *
 * 时间复杂度是O(logn)，其中n是nums数组的长度。空间复杂度是O(1)。
 *
 * 执行用时：1ms，击败94.53%。消耗内存：38.9MB，击败58.09%。
 */
public class Solution1 {
    public int searchInsert(int[] nums, int target) {
        int left = -1, right = nums.length - 1;
        while (left < right) {
            int mid = left + (right - left + 1) / 2;
            if (target <= nums[mid]) {
                right = mid - 1;
            } else {
                left = mid;
            }
        }
        return left + 1;
    }
}
