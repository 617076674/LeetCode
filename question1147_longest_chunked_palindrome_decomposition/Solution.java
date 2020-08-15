package question1147_longest_chunked_palindrome_decomposition;

/**
 * 贪心算法。
 *
 * 时间复杂度是 O(n ^ 2)，其中 n 为 text 的长度。空间复杂度是 O(n)。
 *
 * 执行用时：2ms，击败47.45%。消耗内存：39.6MB，击败31.82%。
 */
public class Solution {
    public int longestDecomposition(String text) {
        int n = text.length();
        for (int i = 1; i <= (n >> 1); i++) {
            if (text.substring(0, i).equals(text.substring(n - i))) {
                return 2 + longestDecomposition(text.substring(i, n - i));
            }
        }
        return n == 0 ? 0 : 1;
    }
}