package question0028_implement_strstr;

/**
 * KMP算法。
 *
 * 时间复杂度是O(n1 + n2)，其中n1为字符串haystack的长度，n2为字符串needle的长度。空间复杂度是O(n2)。
 *
 * 执行用时；11ms，击败12.12%。消耗内存：36.8MB，击败76.60%。
 */
public class Solution2 {
    public int strStr(String haystack, String needle) {
        int n2;
        if (null == needle || (n2 = needle.length()) == 0) {
            return 0;
        }
        int n1;
        if (null == haystack || (n1 = haystack.length()) == 0) {
            return -1;
        }
        int[] next = getNext(needle);
        int j = -1;
        for (int i = 0; i < n1; i++) {
            while (j != -1 && haystack.charAt(i) != needle.charAt(j + 1)) {
                j = next[j];
            }
            if (haystack.charAt(i) == needle.charAt(j + 1)) {
                j++;
            }
            if (j == n2 - 1) {
                return i - j;
            }
        }
        return -1;
    }

    private int[] getNext(String p) {
        int n = p.length(), j = -1;
        int[] next = new int[n];
        next[0] = -1;
        for (int i = 1; i < n; i++) {
            while (j != -1 && p.charAt(i) != p.charAt(j + 1)) {
                j = next[j];
            }
            if (p.charAt(i) == p.charAt(j + 1)) {
                j++;
            }
            next[i] = j;
        }
        return next;
    }
}