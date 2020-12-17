package question0887_super_egg_drop;

/**
 * 记忆化搜索+二分查找法。
 *
 * 时间复杂度是O(K*N*logN)。空间复杂度是O(K*N)。
 *
 * 执行用时：12ms，击败49.11%。消耗内存：40.6MB，击败17.39%。
 */
public class Solution1 {
    private int[][] memo;

    public int superEggDrop(int K, int N) {
        memo = new int[K + 1][N + 1];
        return dfs(K, N);
    }

    private int dfs(int K, int N) {
        if (K == 1) {
            return N;
        }
        if (N == 1 || N == 0) {
            return N;
        }
        if (memo[K][N] != 0) {
            return memo[K][N];
        }
        int left = 1, right = N, result = Integer.MAX_VALUE;
        while (left <= right) {
            int mid = left + ((right - left) >> 1), broken = dfs(K - 1, mid - 1), notBroken = dfs(K, N - mid);
            if (broken > notBroken) {
                right = mid - 1;
                result = Math.min(result, broken + 1);
            } else {
                left = mid + 1;
                result = Math.min(result, notBroken + 1);
            }
        }
        memo[K][N] = result;
        return result;
    }

}