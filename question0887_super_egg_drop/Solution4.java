package question0887_super_egg_drop;

/**
 * 记忆化搜索+二分查找法。
 *
 * 时间复杂度是O(K*N*logN)。空间复杂度是O(K*N)。
 *
 * 执行用时：12ms，击败49.11%。消耗内存：40.6MB，击败17.39%。
 */
public class Solution4 {

    private int[][] memo;

    public int superEggDrop(int K, int N) {
        memo = new int[K + 1][N + 1];
        return superEggDropHelper(K, N);
    }

    private int superEggDropHelper(int K, int N) {
        if (K == 1 || N < 2) {
            return N;
        }
        if (memo[K][N] != 0) {
            return memo[K][N];
        }
        int result = Integer.MAX_VALUE / 2;
        for (int i = 1; i <= N; i++) {
            result = Math.min(result, 1 + Math.max(superEggDropHelper(K - 1, i - 1), superEggDropHelper(K, N - i)));
        }
        memo[K][N] = result;
        return result;
    }

}