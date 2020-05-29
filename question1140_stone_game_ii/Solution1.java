package question1140_stone_game_ii;

/**
 * 记忆化搜索。
 *
 * 时间复杂度和空间复杂度均是 O(n ^ 3)，其中 n 为数组 piles 的长度。
 *
 * 执行用时：0ms，击败100.00%。消耗内存：37MB，击败100.00%。
 */
public class Solution1 {
    private int[] sum;  // sum[i] 表示 [i, piles.length - 1] 范围内的元素和

    private int[][] memo;

    public int stoneGameII(int[] piles) {
        sum = new int[piles.length];
        sum[piles.length - 1] = piles[piles.length - 1];
        for (int i = piles.length - 2; i >= 0; i--) {
            sum[i] = sum[i + 1] + piles[i];
        }
        memo = new int[piles.length][piles.length / 2 + 1];
        return stoneGameII(piles, 0, 1);
    }

    private int stoneGameII(int[] piles, int begin, int M) {
        if (piles.length - begin <= 2 * M) {
            return sum[begin];
        }
        if (memo[begin][M] != 0) {
            return memo[begin][M];
        }
        int result = 0;
        for (int i = 1; i <= 2 * M; i++) {
            result = Math.max(result, sum[begin] - stoneGameII(piles, begin + i, Math.max(M, i)));
        }
        memo[begin][M] = result;
        return result;
    }
}