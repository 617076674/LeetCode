package question1510_stone_game_iv;

/**
 * 时间复杂度是 O(nlogn)。空间复杂度是 O(n)。
 *
 * 执行用时：5ms，击败97.86%。消耗内存：37.6MB，击败20.57%。
 */
public class Solution {

    private int[] memo;

    public boolean winnerSquareGame(int n) {
        memo = new int[n + 1];
        return winnerSquareGameHelper(n) == 1;
    }

    private int winnerSquareGameHelper(int n) {
        if (n == 0) {
            return -1;
        }
        if (memo[n] != 0) {
            return memo[n];
        }
        for (int i = (int) Math.sqrt(n); i >= 1; i--) {
            if (-1 == winnerSquareGameHelper(n - i * i)) {
                memo[n] = 1;
                return 1;
            }
        }
        memo[n] = -1;
        return -1;
    }

}