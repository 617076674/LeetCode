package question0912_sort_an_array;

/**
 * 时间复杂度是O(nlogn)，其中n为nums数组的长度。空间复杂度是O(logn)。
 *
 * 执行用时：7ms，击败91.44%。消耗内存：47.4MB，击败7.38%。
 */
public class Solution {
    public int[] sortArray(int[] nums) {
        sortArray(nums, 0, nums.length - 1);
        return nums;
    }

    private void sortArray(int[] nums, int left, int right) {
        if (left >= right) {
            return;
        }
        swap(nums, left, (int) (left + Math.random() * (right - left) + 1));
        //[left + 1, lessThan], [lessThan + 1, i), [greaterThan, right]
        int lessThan = left, i = left + 1, greaterThan = right + 1;
        while (i < greaterThan) {
            if (nums[i] == nums[left]) {
                i++;
            } else if (nums[i] > nums[left]) {
                greaterThan--;
                swap(nums, i, greaterThan);
            } else {
                lessThan++;
                swap(nums, i, lessThan);
                i++;
            }
        }
        //[left + 1, lessThan], [lessThan + 1, greaterThan - 1], [greaterThan, right]
        swap(nums, left, lessThan);
        lessThan--;
        sortArray(nums, left, lessThan);
        sortArray(nums, greaterThan, right);
    }

    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}