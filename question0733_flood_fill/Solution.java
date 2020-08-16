package question0733_flood_fill;

/**
 * 深搜。
 *
 * 时间复杂度和空间复杂度均是O(m * n)，其中m为image数组的行数，n为image数组的列数。
 *
 * 执行用时：3ms，击败56.64%。消耗内存：48.2MB，击败54.86%。
 */
public class Solution {
    private int m;

    private int n;

    private boolean[][] visited;

    private int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        m = image.length;
        n = image[0].length;
        visited = new boolean[m][n];
        dfs(image, sr, sc);
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (visited[i][j]) {
                    image[i][j] = newColor;
                }
            }
        }
        return image;
    }

    private void dfs(int[][] image, int x, int y) {
        visited[x][y] = true;
        for (int i = 0; i < 4; i++) {
            int newX = x + directions[i][0];
            int newY = y + directions[i][1];
            if (newX >= 0 && newX < m && newY >= 0 && newY < n && image[newX][newY] == image[x][y] && !visited[newX][newY]) {
                dfs(image, newX, newY);
            }
        }
    }
}