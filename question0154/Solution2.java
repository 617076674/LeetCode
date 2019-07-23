package question0154;

/**
 * 二分法。
 *
 * left指向左半边升序数组的第一个元素。right指向右半边升序数组的最后一个元素。
 *
 * 时间复杂度是O(n)，其中n为nums数组的长度。空间复杂度是O(1)。
 *
 * 执行用时：1ms，击败99.52%。消耗内存：37.1MB，击败49.82%。
 */
public class Solution2 {
    public int findMin(int[] nums) {
        int left = 0, right = nums.length - 1;
        while (nums[left] >= nums[right]) {
            if (right - left == 1) {
                return nums[right];
            }
            int mid = left + ((right - left) >> 1);
            if (nums[left] == nums[mid] && nums[mid] == nums[right]) {
                int min = left;
                for (int i = left + 1; i <= right; i++) {
                    if (nums[i] < nums[min]) {
                        min = i;
                    }
                }
                return nums[min];
            }
            if (nums[mid] >= nums[left]) {
                left = mid;
            } else if (nums[mid] <= nums[right]) {
                right = mid;
            }
        }
        return nums[left];
    }
}
