package question1392_longest_happy_prefix;

/**
 * KMP算法求next数组。
 *
 * 时间复杂度和空间复杂度均是O(n)，其中n为字符串s的长度。
 *
 * 执行用时：16ms，击败51.08%。消耗内存：42.5MB，击败100.00%。
 */
public class Solution {
    public String longestPrefix(String s) {
        int n = s.length(), j = -1;
        int[] next = new int[n];
        next[0] = -1;
        for (int i = 1; i < n; i++) {
            while (j != -1 && s.charAt(i) != s.charAt(j + 1)) {
                j = next[j];
            }
            if (s.charAt(i) == s.charAt(j + 1)) {
                j++;
            }
            next[i] = j;
        }
        return s.substring(0, next[n - 1] + 1);
    }
}