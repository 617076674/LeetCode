package question_ji_qi_ren_de_yun_dong_fan_wei_lcof;

/**
 * 深搜。
 *
 * 时间复杂度和空间复杂度均是O(m * n)。
 *
 * 执行用时：1ms，击败90.38%。消耗内存：37MB，击败100.00%。
 */
public class Solution {
    private boolean[][] visited;

    private int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    private int result;

    public int movingCount(int m, int n, int k) {
        visited = new boolean[m][n];
        dfs(m, n, k, 0, 0);
        return result;
    }

    private void dfs(int m, int n, int k, int x, int y) {
        visited[x][y] = true;
        result++;
        for (int i = 0; i < 4; i++) {
            int newX = x + directions[i][0], newY = y + directions[i][1];
            if (newX >= 0 && newX < m && newY >= 0 && newY < n && !visited[newX][newY] && calculate(newX) + calculate(newY) <= k) {
                dfs(m, n, k, newX, newY);
            }
        }
    }

    private int calculate(int num) {
        int result = 0;
        while (num > 0) {
            result += num % 10;
            num /= 10;
        }
        return result;
    }
}