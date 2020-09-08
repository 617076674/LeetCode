package question1444_number_of_ways_of_cutting_a_pizza;

import java.util.Arrays;

/**
 * 记忆化搜索。
 *
 * 时间复杂度是 O((rows * cols) ^ 2)。空间复杂度是 O(rows * cols)。
 *
 * 执行用时：11ms，击败71.67%。消耗内存：37.1MB，击败95.83%。
 */
public class Solution {
    private int rows;

    private int cols;

    private int[][] intPizza;

    private int[][] countApple;

    private int[][] memo;

    private static final int MOD = 1000000007;

    public int ways(String[] pizza, int k) {
        rows = pizza.length;
        cols = pizza[0].length();
        intPizza = new int[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (pizza[i].charAt(j) == 'A') {
                    intPizza[i][j] = 1;
                }
            }
        }
        countApple = new int[rows][cols];
        countApple[rows - 1][cols - 1] = intPizza[rows - 1][cols - 1];
        for (int i = rows - 2; i >= 0; i--) {
            countApple[i][cols - 1] = countApple[i + 1][cols - 1] + intPizza[i][cols - 1];
        }
        for (int j = cols - 2; j >= 0; j--) {
            countApple[rows - 1][j] = countApple[rows - 1][j + 1] + intPizza[rows - 1][j];
        }
        for (int i = rows - 2; i >= 0; i--) {
            for (int j = cols - 2; j >= 0; j--) {
                countApple[i][j] = countApple[i + 1][j] + countApple[i][j + 1] - countApple[i + 1][j + 1] + intPizza[i][j];
            }
        }
        memo = new int[rows * cols][k];
        for (int i = 0; i < memo.length; i++) {
            Arrays.fill(memo[i], -1);
        }
        return ways(0, k - 1);
    }

    private int ways(int status, int k) {
        int row = status / cols, col = status % cols;
        if (k == 0) {
            if (countApple[row][col] > 0) {
                return 1;
            }
            return 0;
        }
        if (countApple[row][col] < k) {
            return 0;
        }
        if (memo[status][k] != -1) {
            return memo[status][k];
        }
        int result = 0;
        // 横切
        for (int i = row + 1; i < rows; i++) {
            if (countApple[row][col] - countApple[i][col] > 0) {
                result += ways(i * cols + col, k - 1);
                result %= MOD;
            }
        }
        // 竖切
        for (int j = col + 1; j < cols; j++) {
            if (countApple[row][col] - countApple[row][j] > 0) {
                result += ways(status + j - col, k - 1);
                result %= MOD;
            }
        }
        memo[status][k] = result;
        return result;
    }
}