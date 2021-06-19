package question1884_egg_drop_with_2_eggs_and_n_floors;

public class Solution1 {

    public int twoEggDrop(int n) {
        memo = new int[3][n + 1];
        return twoEggDropHelper(2, n);
    }

    private int[][] memo;

    private int twoEggDropHelper(int k, int n) {
        if (k == 1 || n < 2) {
            return n;
        }
        if (memo[k][n] != 0) {
            return memo[k][n];
        }
        memo[k][n] = Integer.MAX_VALUE / 2;
        for (int i = 1; i <= n; i++) {
            memo[k][n] = Math.min(memo[k][n], 1 + Math.max(twoEggDropHelper(k - 1, i - 1), twoEggDropHelper(k, n - i)));
        }
        return memo[k][n];
    }

}