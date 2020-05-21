package question0764_largest_plus_sign;

/**
 * 记忆化搜索。
 *
 * 时间复杂度和空间复杂度均是 O(N ^ 2)。
 *
 * 执行用时：161ms，击败61.61%。消耗内存：65.5MB，击败100.00%。
 */
public class Solution2 {
    private int[][] graph;

    private int[][][] memo;

    private int max;

    public int orderOfLargestPlusSign(int N, int[][] mines) {
        graph = new int[N][N];
        for (int[] mine : mines) {
            graph[mine[0]][mine[1]] = 1;
        }
        // memo[i][j][0] 表示从 graph[i][j] 往左走，0的最大个数
        // memo[i][j][1] 表示从 graph[i][j] 往下走，0的最大个数
        // memo[i][j][2] 表示从 graph[i][j] 往右走，0的最大个数
        // memo[i][j][3] 表示从 graph[i][j] 往上走，0的最大个数
        memo = new int[N][N][4];
        for (int i = max; i < N - max; i++) {
            for (int j = max; j < N - max; j++) {
                int tmp = Integer.MAX_VALUE;
                for (int k = 0; k < 4; k++) {
                    tmp = Math.min(tmp, orderOfLargestPlusSign(i, j, k));
                }
                max = Math.max(max, tmp);
            }
        }
        return max;
    }

    private int orderOfLargestPlusSign(int i, int j, int k) {
        if (graph[i][j] == 1) {
            return 0;
        }
        if (memo[i][j][k] != 0) {
            return memo[i][j][k];
        }
        if ((k == 0 && j == 0) || (k == 1 && i == graph.length - 1) || (k == 2 && j == graph.length - 1) || (k == 3 && i == 0)) {
            return 1;
        }
        int result;
        switch (k) {
            case 0:
                result = orderOfLargestPlusSign(i, j - 1, 0) + 1;
                break;
            case 1:
                result = orderOfLargestPlusSign(i + 1, j, 1) + 1;
                break;
            case 2:
                result = orderOfLargestPlusSign(i, j + 1, 2) + 1;
                break;
            default:
                result = orderOfLargestPlusSign(i - 1, j, 3) + 1;
        }
        memo[i][j][k] = result;
        return result;
    }
}