package question0153;

/**
 * 二分法。
 *
 * left指向左半边升序数组的第一个元素。right指向右半边升序数组的最后一个元素。
 *
 * 时间复杂度是O(logn)，其中n为nums数组的长度。空间复杂度是O(1)。
 *
 * 执行用时：1ms，击败97.91%。消耗内存：36MB，击败40.66%。
 */
public class Solution2 {
    public int findMin(int[] nums) {
        int left = 0, right = nums.length - 1;
        while (nums[left] > nums[right]) {
            if (right - left == 1) {
                return nums[right];
            }
            int mid = left + ((right - left) >> 1);
            if (nums[mid] > nums[left]) {
                left = mid;
            } else if (nums[mid] < nums[right]) {
                right = mid;
            }
        }
        return nums[left];
    }
}
