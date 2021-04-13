package question0074_search_a_2d_matrix;

/**
 * 先对每行第一列的数据用floor函数进行查找。
 *
 * 再对找到的那一行进行二分查找法。
 *
 * 时间复杂度是O(log(m) + log(n))，其中m是矩阵的行数，n是矩阵的列数。空间复杂度是O(1)。
 *
 * 执行用时：1ms，击败99.30%。消耗内存：38.9MB，击败86.55%。
 */
public class Solution1 {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m;
        if (null == matrix || (m = matrix.length) == 0) {
            return false;
        }
        if (null == matrix[0] || matrix[0].length == 0) {
            return false;
        }
        int[] array = new int[m];
        for (int i = 0; i < m; i++) {
            array[i] = matrix[i][0];
        }
        int row = floor(array, target);
        if (row == -1) {
            return false;
        }
        return binarySearch(matrix[row], target);
    }

    private boolean binarySearch(int[] array, int target) {
        int left = 0, right = array.length - 1;
        while (left <= right) {
            int mid = left + ((right - left) >> 1);
            if (array[mid] == target) {
                return true;
            } else if (array[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return false;
    }

    private int floor(int[] array, int target) {
        int left = -1, right = array.length - 1;
        while (left < right) {
            int mid = left + ((right - left + 1) >> 1);
            if (array[mid] < target) {
                left = mid;
            } else {
                right = mid - 1;
            }
        }
        if (left + 1 < array.length && array[left + 1] == target) {
            return left + 1;
        }
        return left;
    }
}