package question0130_surrounded_regions;

/**
 * 并查集。
 * <p>
 * 时间复杂度和空间复杂度均是O(m * n)，其中m为board数组的行数，n为board数组的列数。
 * <p>
 * 执行用时：5ms，击败23.57%。消耗内存：41.6MB，击败56.25%。
 */
public class Solution2 {
  private int[] parent;

  public void solve(char[][] board) {
    int m;
    if (null == board || (m = board.length) == 0) {
      return;
    }
    int n;
    if (null == board[0] || (n = board[0].length) == 0) {
      return;
    }
    parent = new int[m * n + 1];    // 新增一个虚拟节点 m * n，将所有边界上的 O 都与这个虚拟节点相连接
    for (int i = 0; i < parent.length; i++) {
      parent[i] = i;
    }
    for (int i = 0; i < m; i++) {
      for (int j = 0; j < n; j++) {
        if ((i == 0 || i == m - 1 || j == 0 || j == n - 1) && board[i][j] == 'O') {
          union(i * n + j, m * n);
        }
      }
    }
    int[][] directions = new int[][] {{1, 0}, {0, 1}, {0, -1}, {-1, 0}};
    for (int i = 1; i < m - 1; i++) {
      for (int j = 1; j < n - 1; j++) {
        if (board[i][j] == 'O') {
          for (int k = 0; k < 4; k++) {
            int newI = i + directions[k][0], newJ = j + directions[k][1];
            if (board[newI][newJ] == 'O') {
              union(newI * n + newJ, i * n + j);
            }
          }
        }
      }
    }
    for (int i = 1; i < m - 1; i++) {
      for (int j = 1; j < n - 1; j++) {
        if (findParent(m * n) != findParent(i * n + j)) {
          board[i][j] = 'X';
        }
      }
    }
  }

  private void union(int a, int b) {
    int aParent = findParent(a), bParent = findParent(b);
    if (aParent != bParent) {
      parent[aParent] = bParent;
    }
  }

  private int findParent(int x) {
    int a = x;
    while (x != parent[x]) {
      x = parent[x];
    }
    while (a != parent[a]) {
      int z = a;
      a = parent[a];
      parent[z] = x;
    }
    return x;
  }
}