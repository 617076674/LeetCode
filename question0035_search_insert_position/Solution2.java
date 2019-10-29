package question0035_search_insert_position;

/**
 * ceil()函数的实现，寻找nums数组中值大于target的最小值所在的索引。
 *
 * 时间复杂度是O(logn)，其中n是nums数组的长度。空间复杂度是O(1)。
 *
 * 执行用时：1ms，击败94.53%。消耗内存：39MB，击败55.56%。
 */
public class Solution2 {
    public int searchInsert(int[] nums, int target) {
        int left = 0, right = nums.length;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (target >= nums[mid]) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        if (left - 1 >= 0 && nums[left - 1] == target) {
            return left - 1;
        }
        return left;
    }
}