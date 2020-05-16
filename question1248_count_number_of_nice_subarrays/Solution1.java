package question1248_count_number_of_nice_subarrays;

/**
 * 双指针。
 *
 * 时间复杂度是 O(n)，其中 n 为 nums 数组的长度。空间复杂度是 O(1)。
 *
 * 执行用时：6ms，击败85.47%。消耗内存：48MB，击败100.00%。
 */
public class Solution1 {
    public int numberOfSubarrays(int[] nums, int k) {
        // 滑动窗口的范围是 [left, right)
        int left = 0, right = 0, countOdd = 0, result = 0;
        while (right < nums.length) {
            if ((nums[right] & 1) == 1) {
                countOdd++;
            }
            right++;
            if (countOdd == k) {
                int tmp = right;
                while (right < nums.length && (nums[right] & 1) == 0) {
                    right++;
                }
                result += right - tmp + 1;
                while ((nums[left] & 1) == 0 && left < right) {
                    left++;
                    result += right - tmp + 1;
                }
                countOdd--;
                left++;
            }
        }
        return result;
    }
}