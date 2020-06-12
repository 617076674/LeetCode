package question0639_decode_ways_ii;

/**
 * 记忆化搜索。
 *
 * 时间复杂度和空间复杂度均是 O(n)，其中 n 为字符串 s 的长度。
 *
 * 执行用时：92ms，击败9.80%。消耗内存：70.4MB，击败50.00%。
 */
public class Solution1 {
    private static final int MOD = 1000000007;

    private long[] memo;

    public int numDecodings(String s) {
        memo = new long[s.length()];
        return (int) numDecodings(s, s.length() - 1);
    }

    /**
     * 字符串 s 中 [0, last] 范围内的子串所能解码的数量
     */
    private long numDecodings(String s, int last) {
        if (last < 0) {
            return 1;
        } else if (last == 0) {
            return s.charAt(0) == '*' ? 9 : s.charAt(0) == '0' ? 0 : 1;
        } else if (memo[last] != 0) {
            return memo[last];
        }
        char c1 = s.charAt(last), c2 = s.charAt(last - 1);
        long result;
        if (c1 == '*') {
            result = numDecodings(s, last - 1) * 9;
            if (c2 == '*') {
                result += numDecodings(s, last - 2) * 15;
            } else if (c2 == '1') {
                result += numDecodings(s, last - 2) * 9;
            } else if (c2 == '2') {
                result += numDecodings(s, last - 2) * 6;
            }
        } else if (c1 == '0') {
            result = 0;
            if (c2 == '*') {
                result = 2 * numDecodings(s, last - 2);
            } else if (c2 == '1' || c2 == '2') {
                result = numDecodings(s, last - 2);
            }
        } else if (c1 <= '6') {
            result = numDecodings(s, last - 1);
            if (c2 == '*') {
                result += numDecodings(s, last - 2) * 2;
            } else if (c2 == '1' || c2 == '2') {
                result += numDecodings(s, last - 2);
            }
        } else {
            result = numDecodings(s, last - 1);
            if (c2 == '*' || c2 == '1') {
                result += numDecodings(s, last - 2);
            }
        }
        memo[last] = result % MOD;
        return memo[last];
    }
}