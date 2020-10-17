package question1575_count_all_possible_routes;

import java.util.Arrays;

/**
 * 记忆化搜索。
 *
 * 时间复杂度和空间复杂度均是 O(locations.length * fuel)。
 *
 * 执行用时：95ms，击败69.42%。消耗内存：38.5MB，击败76.32%。
 */
public class Solution {

    private static final int MOD = 1000000007;

    private int[][] memo;

    public int countRoutes(int[] locations, int start, int finish, int fuel) {
        memo = new int[locations.length][fuel + 1];
        for (int i = 0; i < locations.length; i++) {
            Arrays.fill(memo[i], -1);
        }
        return countRoutesHelper(locations, start, finish, fuel);
    }

    private int countRoutesHelper(int[] locations, int start, int finish, int fuel) {
        if (fuel == 0) {
            if (start == finish) {
                return 1;
            }
            return 0;
        }
        if (fuel < 0) {
            return 0;
        }
        if (memo[start][fuel] != -1) {
            return memo[start][fuel];
        }
        int result = 0;
        for (int i = 0; i < locations.length; i++) {
            if (start != i) {
                result += countRoutesHelper(locations, i, finish, fuel - Math.abs(locations[i] - locations[start]));
                result %= MOD;
            }
        }
        if (start == finish) {
            result++;
        }
        memo[start][fuel] = result;
        return result;
    }

}