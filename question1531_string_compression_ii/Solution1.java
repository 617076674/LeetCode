package question1531_string_compression_ii;

import java.util.Arrays;

/**
 * 记忆化搜索。
 *
 * 执行用时：769ms，击败20.15%。消耗内存：214.1MB，击败5.02%
 */
public class Solution1 {

    private int[][][][] memo;

    public int getLengthOfOptimalCompression(String s, int k) {
        memo = new int[k + 1][s.length() + 1][27][s.length() + 1];
        for (int i = 0; i < k + 1; i++) {
            for (int j = 0; j < s.length() + 1; j++) {
                for (int l = 0; l < 27; l++) {
                    Arrays.fill(memo[i][j][l], -1);
                }
            }
        }
        return getLengthOfOptimalCompression(s, k, 0, 26, 0);
    }

    private int getLengthOfOptimalCompression(String s, int k, int index, int pre, int preLen) {
        if (index + k >= s.length()) {
            return 0;
        }
        if (memo[k][index][pre][preLen] != -1) {
            return memo[k][index][pre][preLen];
        }
        int result;
        if (pre == s.charAt(index) - 'a') {
            result = getLengthOfOptimalCompression(s, k, index + 1, pre, preLen + 1);
            if (preLen == 1 || preLen == 9 || preLen == 99) {
                result++;
            }
        } else {
            result = 1 + getLengthOfOptimalCompression(s, k, index + 1, s.charAt(index) - 'a', 1);
            if (k > 0) {
                result = Math.min(getLengthOfOptimalCompression(s, k - 1, index + 1, pre, preLen), result);
            }
        }
        memo[k][index][pre][preLen] = result;
        return result;
    }

}