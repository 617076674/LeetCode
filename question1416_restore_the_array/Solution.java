package question1416_restore_the_array;

import java.util.Arrays;

/**
 * 时间复杂度和空间复杂度均是 O(n)，其中 n 为字符串 s 的长度。
 *
 * 执行用时：432ms，击败13.89%。消耗内存：63.3MB，击败6.52%，
 */
public class Solution {
    private long[] memo;

    private static final int MOD = 1000000007;

    public int numberOfArrays(String s, int k) {
        memo = new long[s.length()];
        Arrays.fill(memo, -1);
        return (int) numberOfArrays(s, 0, k);
    }

    private long numberOfArrays(String s, int left, int k) {
        if (left == s.length()) {
            return 1;
        }
        if (memo[left] != -1) {
            return memo[left];
        }
        long result = 0;
        for (int i = left; i < Math.min(s.length(), left + 10); i++) {
            long num = Long.parseLong(s.substring(left, i + 1));
            if (num <= k && num >= 1 && ((i + 1 >= s.length()) || (i + 1 < s.length() && s.charAt(i + 1) != '0'))) {
                result += numberOfArrays(s, i + 1, k);
                result %= MOD;
            }
        }
        memo[left] = result;
        return result;
    }
}