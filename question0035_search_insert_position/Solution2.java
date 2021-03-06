package question0035_search_insert_position;

/**
 * 因为数组中无重复元素，故可用ceil()函数实现，寻找nums数组中值大于target的最小值所在的索引。
 *
 * 时间复杂度是O(logn)，其中n是nums数组的长度。空间复杂度是O(1)。
 *
 * 执行用时：1ms，击败94.53%。消耗内存：39MB，击败55.56%。
 */
public class Solution2 {
    public int searchInsert(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = left + ((right - left) >> 1);
            if (target == nums[mid]) {
                left = mid + 1;
            } else if (target < nums[mid]) {
                right = mid - 1;
            } else if (target > nums[mid]) {
                left = mid + 1;
            }
        }
        if (right < 0 || nums[right] != target) {
            return right + 1;
        }
        return right;
    }
}