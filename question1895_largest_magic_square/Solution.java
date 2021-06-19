package question1895_largest_magic_square;

public class Solution {

    public int largestMagicSquare(int[][] grid) {
        int m = grid.length, n = grid[0].length, result = 1;
        int[][] rowSums = new int[m][n + 1];
        // rowSums[i][j] = grid[i][0] + ... + grid[i][j - 1]
        for (int i = 0; i < m; i++) {
            for (int j = 1; j < n + 1; j++) {
                rowSums[i][j] = rowSums[i][j - 1] + grid[i][j - 1];
            }
        }
        int[][] colSums = new int[m + 1][n];
        // colSums[i][j] = grid[0][j] + ... + grid[i - 1][j]
        for (int j = 0; j < n; j++) {
            for (int i = 1; i < m + 1; i++) {
                colSums[i][j] = colSums[i - 1][j] + grid[i - 1][j];
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = result + 1; i + k - 1 < m && j + k - 1 < n; k++) {
                    int sum1 = 0, sum2 = 0;
                    for (int l = 0; l < k; l++) {
                        sum1 += grid[i + l][j + l];
                        sum2 += grid[i + l][j + k - 1 - l];
                    }
                    if (sum1 != sum2) {
                        continue;
                    }
                    boolean flag = true;
                    for (int l = i; l <= i + k - 1; l++) {
                        if (rowSums[l][j + k] - rowSums[l][j] != sum1) {
                            flag = false;
                            break;
                        }
                    }
                    if (flag) {
                        for (int l = j; l <= j + k - 1; l++) {
                            if (colSums[i + k][l] - colSums[i][l] != sum1) {
                                flag = false;
                                break;
                            }
                        }
                        if (flag) {
                            result = Math.max(result, k);
                        }
                    }
                }
            }
        }
        return result;
    }

}