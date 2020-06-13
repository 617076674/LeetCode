package question0730_count_different_palindromic_subsequences;

import java.util.Arrays;

/**
 * 记忆化搜索。
 *
 * 回文串可以分为两种类型：
 * （1）由单个字符组成。
 * （2）以形式"a...a"、"b...b"、"c...c"或"d...d"出现。
 *
 * 时间复杂度和空间复杂度均是 O(n ^ 2)，其中 n 为字符串 S 的长度。
 *
 * 执行用时：52ms，击败73.83%。消耗内存：50.4MB，击败100.00%。
 */
public class Solution {
    private char[] chars = {'a', 'b', 'c', 'd'};

    private static final int MOD = 1000000007;

    private int[][] countLetter, memo, next, pre;

    public int countPalindromicSubsequences(String S) {
        countLetter = new int[S.length()][4];
        for (int i = 0; i < 4; i++) {
            if (S.charAt(0) == chars[i]) {
                countLetter[0][i]++;
                break;
            }
        }
        for (int i = 1; i < S.length(); i++) {
            for (int j = 0; j < 4; j++) {
                countLetter[i][j] = countLetter[i - 1][j];
                if (S.charAt(i) == chars[j]) {
                    countLetter[i][j]++;
                }
            }
        }
        int single = 0;
        for (int i = 0; i < 4; i++) {
            if (countLetter[S.length() - 1][i] > 0) {
                single++;
            }
        }
        next = new int[S.length()][4];
        for (int i = 0; i < S.length(); i++) {
            Arrays.fill(next[i], -1);
        }
        for (int i = 0; i < S.length(); i++) {
            int k = 0;
            for (; k < 4; k++) {
                if (S.charAt(i) == chars[k]) {
                    break;
                }
            }
            next[i][k] = i;
            for (int j = i - 1; j >= 0; j--) {
                if (next[j][k] == -1) {
                    next[j][k] = i;
                }
            }
        }
        pre = new int[S.length()][4];
        for (int i = 0; i < S.length(); i++) {
            Arrays.fill(pre[i], -1);
        }
        for (int i = S.length() - 1; i >= 0; i--) {
            int k = 0;
            for (; k < 4; k++) {
                if (S.charAt(i) == chars[k]) {
                    break;
                }
            }
            pre[i][k] = i;
            for (int j = i + 1; j < S.length(); j++) {
                if (pre[j][k] == -1) {
                    pre[j][k] = i;
                }
            }
        }
        memo = new int[S.length()][S.length()];
        return (single + countPalindromicSubsequences(S, 0, S.length() - 1)) % MOD;
    }

    private int countPalindromicSubsequences(String S, int left, int right) {
        if (left >= right) {
            return 0;
        }
        if (memo[left][right] != 0) {
            return memo[left][right];
        }
        int result = 0;
        for (int k = 0; k < 4; k++) {
            int i = next[left][k];
            if (i != -1 && i < right) {
                int j = pre[right][k];
                if (j > i) {
                    int single = 1;
                    for (int l = 0; l < 4; l++) {
                        if (countLetter[j - 1][l] - countLetter[i][l] > 0) {
                            single++;
                        }
                    }
                    result += single + countPalindromicSubsequences(S, i + 1, j - 1);
                    result %= MOD;
                }
            }
        }
        memo[left][right] = result;
        return result;
    }
}