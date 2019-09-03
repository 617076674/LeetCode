package question0467;

/**
 * 用一个大小为26的int型数组count记录每个字符结尾的最长子串的长度。
 *
 * 时间复杂度是O(n ^ 2)，其中n为字符串p的长度。空间复杂度是O(1)。
 *
 * 执行用时：699ms，击败5.26%。消耗内存：39MB，击败66.67%。
 */
public class Solution1 {
    public int findSubstringInWraproundString(String p) {
        //count[0]表示以字符'a'结尾的最长子串的长度
        //count[1]表示以字符'b'结尾的最长子串的长度
        //......
        //count[25]表示以字符'z'结尾的最长子串的长度
        int[] count = new int[26];
        for (int i = 0; i < p.length(); i++) {
            char c = p.charAt(i);
            int tmp = i;
            while (tmp - 1 >= 0 && (p.charAt(tmp) - p.charAt(tmp - 1) + 26) % 26 == 1) {
                tmp--;
            }
            count[c - 'a'] = Math.max(count[c - 'a'], i - tmp + 1);
        }
        int result = 0;
        for (int i = 0; i < 26; i++) {
            result += count[i];
        }
        return result;
    }
}
