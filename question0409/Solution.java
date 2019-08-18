package question0409;

/**
 * @author qianyihui
 * @date 2019-08-17
 *
 * 统计每个字符出现的次数。
 *
 * 对于偶数个数的字符，全部都可加入回文串中。对于奇数个数的字符，其减1后的个数的字符可以加入回文串中。
 *
 * 最后，如果有出现奇数个数的字符，则将结果加1。
 *
 * 时间复杂度和空间复杂度均是O(n)，其中n为字符串s的长度。
 *
 * 执行用时：5ms，击败44.83%。消耗内存：35.9MB，击败80.56%。
 */
public class Solution {
    public int longestPalindrome(String s) {
        int[] map = new int[52];
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c >= 'a' && c <= 'z') {
                map[c - 'a']++;
            } else {
                map[c - 'A' + 26]++;
            }
        }
        int result = 0;
        boolean hasOdd = false;
        for (int i = 0; i < map.length; i++) {
            if ((map[i] & 1) == 0) {
                result += map[i];
            } else {
                hasOdd = true;
                result += map[i] - 1;
            }
        }
        if (hasOdd) {
            result++;
        }
        return result;
    }
}