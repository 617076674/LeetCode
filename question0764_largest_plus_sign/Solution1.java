package question0764_largest_plus_sign;

/**
 * 暴力破解法。
 *
 * 时间复杂度是 O(N ^ 3)。空间复杂度是 O(N ^ 2)。
 *
 * 执行用时：669ms，击败8.48%。消耗内存：42.2MB，击败100.00%。
 */
public class Solution1 {
    public int orderOfLargestPlusSign(int N, int[][] mines) {
        int[][] graph = new int[N][N];
        for (int[] mine : mines) {
            graph[mine[0]][mine[1]] = 1;
        }
        int[][] directions = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
        int result = 0;
        for (int i = result; i < N - result; i++) {
            for (int j = result; j < N - result; j++) {
                if (graph[i][j] == 0) {
                    int k = 1;
                    while (true) {
                        boolean flag = true;
                        for (int[] direction : directions) {
                            int newI = direction[0] * k + i, newJ = direction[1] * k + j;
                            if (newI < 0 || newI >= N || newJ < 0 || newJ >= N || graph[newI][newJ] != 0) {
                                flag = false;
                                break;
                            }
                        }
                        if (!flag) {
                            break;
                        }
                        k++;
                    }
                    result = Math.max(result, k);
                }
            }
        }
        return result;
    }
}