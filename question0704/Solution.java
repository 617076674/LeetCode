package question0704;

/**
 * @author qianyihui
 * @date 2019-08-09
 *
 * 时间复杂度是O(logn)，其中n为nums数组的长度。空间复杂度是O(1)。
 *
 * 执行用时：1ms，击败83.40%。消耗内存：48.9MB，击败52.85%。
 */
public class Solution {
    public int search(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left < right) {
            int mid = (left + right + 1) >>> 1;
            if (target < nums[mid]) {
                right = mid - 1;
            } else {
                left = mid;
            }
        }
        if (nums[left] == target) {
            return left;
        }
        return -1;
    }
}
