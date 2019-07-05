package question0074;

/**
 * 先对每行最后一列的数据用ceil函数进行查找。
 *
 * 再对找到的那一行进行二分查找法。
 *
 * 时间复杂度是O(log(m) + log(n))，其中m是矩阵的行数，n是矩阵的列数。空间复杂度是O(1)。
 *
 * 执行用时：1ms，击败99.30%。消耗内存：39.8MB，击败76.97%。
 */
public class Solution2 {

    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        if (m == 0) {
            return false;
        }
        int n = matrix[0].length;
        if (n == 0) {
            return false;
        }
        int[] array = new int[m];
        for (int i = 0; i < m; i++) {
            array[i] = matrix[i][n - 1];
        }
        int row = ceil(array, target);
        if (row == m) {
            return false;
        }
        return binarySearch(matrix[row], target);
    }

    private boolean binarySearch(int[] array, int target) {
        int left = 0, right = array.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
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

    private int ceil(int[] array, int target) {
        int left = 0, right = array.length;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (array[mid] < target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        if (right - 1 >= 0 && array[right - 1] == target) {
            return right - 1;
        }
        return right;
    }

}
