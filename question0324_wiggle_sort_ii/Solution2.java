package question0324_wiggle_sort_ii;

/**
 * https://leetcode.com/problems/wiggle-sort-ii/discuss/77682/Step-by-step-explanation-of-index-mapping-in-Java
 *
 * 时间复杂度是O(n)，其中n为nums数组的长度。空间复杂度是O(1)。
 *
 * 执行用时：11ms，击败26.22%。消耗内存：40MB，击败98.20%。
 */
public class Solution2 {
    public void wiggleSort(int[] nums) {
        int n = nums.length, median = findKthLargest(nums, (n + 1) >> 1);
        int left = 0, i = 0, right = n - 1;
        while (i <= right) {
            if (nums[newIndex(i, n)] > median) {
                swap(nums, newIndex(left++, n), newIndex(i++, n));
            } else if (nums[newIndex(i, n)] < median) {
                swap(nums, newIndex(right--, n), newIndex(i, n));
            } else {
                i++;
            }
        }
    }

    private int findKthLargest(int[] nums, int k) {
        return findKthLargest(nums, k, 0, nums.length - 1);
    }

    private int findKthLargest(int[] nums, int k, int left, int right) {
        if (left == right && k == 1) {
            return nums[left];
        }
        swap(nums, left, (int) (left + 1 + Math.random() * (right - left)));
        // [left + 1, lessThan], [lessThan + 1, i), [greaterThan, right]
        int lessThan = left, i = lessThan + 1, greaterThan = right + 1;
        while (i < greaterThan) {
            if (nums[i] == nums[left]) {
                i++;
            } else if (nums[i] < nums[left]) {
                lessThan++;
                swap(nums, lessThan, i);
                i++;
            } else {
                greaterThan--;
                swap(nums, greaterThan, i);
            }
        }
        swap(nums, left, lessThan);
        lessThan--;
        //                           ---->递增
        //[left, lessThan], [lessThan + 1, greaterThan - 1], [greaterThan, right]
        //                           ---->递减
        //[right - left + 1, right - lessThan + 1], [right - lessThan, right - greaterThan + 2], [right - greaterThan + 1, 1]
        if (k >= right - greaterThan + 2 && k <= right - lessThan) {
            return nums[lessThan + 1];
        } else if (k <= right - greaterThan + 1) {
            return findKthLargest(nums, k, greaterThan, right);
        }
        return findKthLargest(nums, k - right + lessThan, left, lessThan);
    }

    private int newIndex(int index, int n) {
        return (1 + (index << 1)) % (n | 1);
    }

    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}