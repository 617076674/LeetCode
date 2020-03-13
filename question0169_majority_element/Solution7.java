package question0169_majority_element;

/**
 * 寻找第K大数。K = nums.length / 2。快排思想的运用。
 *
 * 时间复杂度是n + n / 2 + n / 4 + ... = 2n，即O(2n)。其中n为nums数组的长度。空间复杂度是O(logn)。
 *
 * 执行用时：7ms，击败40.68%。消耗内存51.8MB，击败11.79%。
 */
public class Solution7 {
    public int majorityElement(int[] nums) {
        return findKthMax(nums, 0, nums.length - 1, (nums.length >> 1) + 1);
    }

    private int findKthMax(int[] nums, int left, int right, int K) {
        if (left == right) {
            return nums[left];
        }
        swap(nums, left, (int) (Math.random() * (right - left)) + left);
        //[left + 1, lessThan]   [lessThan + 1, i)     [greaterThan, right]
        int lessThan = left, i = left + 1, greaterThan = right + 1;
        while (i < greaterThan) {
            if (nums[i] == nums[left]) {
                i++;
            } else if (nums[i] < nums[left]) {
                lessThan++;
                swap(nums, lessThan, i);
                i++;
            } else {
                greaterThan--;
                swap(nums, i, greaterThan);
            }
        }
        swap(nums, left, lessThan);
        lessThan--;
        //[left, lessThan]   [lessThan + 1, greaterThan - 1]  [greaterThan, right]
        if (K <= right - greaterThan + 1) {
            return findKthMax(nums, greaterThan, right, K);
        } else if (K > right - lessThan) {
            return findKthMax(nums, left, lessThan, K - right + lessThan);
        }
        return nums[lessThan + 1];
    }

    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}