package question1351_count_negative_numbers_in_a_sorted_matrix;

/**
 * 反向ceil()函数的实现。
 *
 * 时间复杂度是O(mlogn)，其中m是矩阵grid的行数，n是矩阵grid的列数。空间复杂度是O(1)。
 *
 * 执行用时：0ms，击败100.00%。消耗内存：41.9MB，击败100.00%。
 */
public class Solution2 {
    public int countNegatives(int[][] grid) {
        int m;
        if (null == grid || (m = grid.length) == 0) {
            return 0;
        }
        int n;
        if (null == grid[0] || (n = grid[0].length) == 0) {
            return 0;
        }
        int result = 0;
        for (int i = 0; i < m; i++) {
            int indexOf0 = ceil(grid[i], 0);
            if (indexOf0 < n) {
                result += n - indexOf0;
                if (grid[i][indexOf0] == 0) {
                    result--;
                }
            }
        }
        return result;
    }

    private int ceil(int[] nums, int target) {
        int left = 0, right = nums.length;
        while (left < right) {
            int mid = left + ((right - left) >> 1);
            if (nums[mid] >= target) {  //如果是非递减排列的nums数组，此处是nums[mid] <= target
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