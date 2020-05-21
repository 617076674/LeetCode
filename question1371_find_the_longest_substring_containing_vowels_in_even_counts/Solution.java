package question1371_find_the_longest_substring_containing_vowels_in_even_counts;

import java.util.Arrays;

/**
 * 对于某一字符串，5个元音字母出现的次数可以分别为奇数和偶数，那么总共会有2 ^ 5种状态。（用5位二进制数表示状态）
 *
 * 如果说[i, j]间的字符串是满足题目要求的，那么[0, i - 1]中字符串的状态肯定和[0, j]中字符串的状态相同。
 * （偶数 - 偶数 = 偶数，奇数 - 奇数 = 偶数，偶数 - 奇数 = 奇数， 奇数 - 偶数 = 奇数）
 *
 * 记录每个状态出现时的最小的索引，对于当前状态status，寻找之前出现过的该状态对应的字符串s的最小索引，这样才取得以j结尾的最长满足条件的字符串。
 *
 * 特别地，当未遍历s中任何一个字符时，状态是0，其对应的索引应初始化为-1。
 *
 * 时间复杂度是O(n)，其中n为字符串s的长度。空间复杂度是O(1)。
 *
 * 执行用时：27ms，击败100.00%。消耗内存：43.3MB，击败100.00%。
 */
public class Solution {
    public int findTheLongestSubstring(String s) {
        int result = 0, status = 0;
        int[] position = new int[1 << 5];
        Arrays.fill(position, Integer.MAX_VALUE);
        position[0] = -1;
        char[] chars = {'a', 'e', 'i', 'o', 'u'};
        for (int i = 0; i < s.length(); i++) {
            for (int j = 0; j < chars.length; j++) {
                if (s.charAt(i) == chars[j]) {
                    status ^= (1 << j);
                    break;
                }
            }
            position[status] = Math.min(i, position[status]);
            result = Math.max(result, i - position[status]);
        }
        return result;
    }
}