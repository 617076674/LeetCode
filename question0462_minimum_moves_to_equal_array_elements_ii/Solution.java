package question0462_minimum_moves_to_equal_array_elements_ii;

/**
 * 假设最终数组a中的每个数均为x，那么需要移动的次数即为|a[0] - x| + |a[1] - x| + ... + |a[n-1] - x|。
 *
 * 当x为这个N个数的中位数时，可以使得距离最小。若N为偶数，中间的两个数为p和q，此时x只要是区间[p, q]中的任意一个数即可。
 *
 * 时间复杂度是O(n)，其中n为nums数组的长度。空间复杂度是O(logn)。
 *
 * 执行用时：4ms，击败63.93%。消耗内存：41.3MB，击败5.39%。
 */
public class Solution {
    public int minMoves2(int[] nums) {
        int n;
        if (null == nums || (n = nums.length) == 0) {
            return 0;
        }
        int target = findKthNumber(nums, 0, n - 1, n >> 1), result = 0;
        for (int num : nums) {
            result += Math.abs(num - target);
        }
        return result;
    }

    /**
     * 寻找nums数组中[left, right]范围内的第K小数，K从0开始计数
     */
    private int findKthNumber(int[] nums, int left, int right, int K) {
        if (left == right && K == 0) {
            return nums[left];
        }
        swap(nums, left, (int) (Math.random() * (right - left) + left + 1));
        //[left + 1, lessThan], [lessThan + 1, i), [greaterThan, right]
        int lessThan = left, i = lessThan + 1, greaterThan = right + 1;
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
        //[left, lessThan], [lessThan + 1, greaterThan - 1], [greaterThan, right]
        if (K <= lessThan - left) {
            return findKthNumber(nums, left, lessThan, K);
        } else if (K <= greaterThan - left - 1) {
            return nums[lessThan + 1];
        }
        return findKthNumber(nums, greaterThan, right, K - greaterThan + left);
    }

    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}