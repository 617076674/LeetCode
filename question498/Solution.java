package question498;

/**
 * 关键在于找到规律：对于某一条斜线上的点，其横坐标和纵坐标之和是一个定值。
 * <p>
 * 至于遍历的方向，根据横纵坐标之和的奇偶性来判别。
 * <p>
 * 时刻注意数组越界的情况。
 * <p>
 * 时间复杂度和空间复杂度均是O(m*n)，其中m为数组的行数，n为数组的列数
 * <p>
 * 执行用时：7ms，击败47.93%。内存消耗：50.4M，击败61.66%。
 */
public class Solution {

    public int[] findDiagonalOrder(int[][] matrix) {
        int m = matrix.length;
        if (m == 0) {
            return new int[0];
        }
        int n = matrix[0].length;
        int[] result = new int[m * n];
        int index = 0;
        for (int gap = 0; gap < m + n - 1; gap++) {
            int min = Math.max(0, gap - n + 1), max = Math.min(gap, m - 1);
            if (gap % 2 == 1) {
                for (int i = min; i <= max; i++) {
                    result[index++] = matrix[i][gap - i];
                }
            } else {
                for (int i = max; i >= min; i--) {
                    result[index++] = matrix[i][gap - i];
                }
            }
        }
        return result;
    }

}
