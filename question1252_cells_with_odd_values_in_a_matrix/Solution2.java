package question1252_cells_with_odd_values_in_a_matrix;

/**
 * 统计每行每列增加的次数。
 *
 * 时间复杂度和空间复杂度均是O(n + m)。
 *
 * 执行用时：0ms，击败100.00%。消耗内存：37.6MB，击败19.65%。
 */
public class Solution2 {
    public int oddCells(int n, int m, int[][] indices) {
        int[] rows = new int[n], cols = new int[m];
        for (int i = 0; i < indices.length; i++) {
            rows[indices[i][0]]++;
            cols[indices[i][1]]++;
        }
        int colEven = 0, colOdd = 0, result = 0;
        for (int i = 0; i < m; i++) {
            if ((cols[i] & 1) == 1) {
                colOdd++;
            } else {
                colEven++;
            }
        }
        for (int i = 0; i < n; i++) {
            if ((rows[i] & 1) == 1) {   //第i行加1的次数为奇数次，那么该行中对应加1的次数为偶数次的列上的数是奇数
                result += colEven;
            } else {
                result += colOdd;   //第i行加1的次数为偶数次，那么该行中对应加1的次数为奇数次的列上的数是奇数
            }
        }
        return result;
    }
}