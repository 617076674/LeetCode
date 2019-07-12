package question0796;

/**
 * @author qianyihui
 * @date 2019-07-12
 *
 * KMP算法。
 *
 * 时间复杂度和空间复杂度均是O(n)，其中n为字符串A的长度。
 *
 * 执行用时：2ms，击败32.71%。消耗内存：35MB，击败59.90%。
 */
public class Solution2 {
    public boolean rotateString(String A, String B) {
        if (A.equals(B)) {
            return true;
        }
        if (A.length() != B.length()) {
            return false;
        }
        return match(A + A, B);
    }

    private boolean match(String s, String p) {
        int[] next = getNext(p);
        int j = -1;
        for (int i = 0; i < s.length(); i++) {
            while (j != -1 && s.charAt(i) != p.charAt(j + 1)) {
                j = next[j];
            }
            if (s.charAt(i) == p.charAt(j + 1)) {
                j++;
            }
            if (j == p.length() - 1) {
                return true;
            }
        }
        return false;
    }

    private int[] getNext(String s) {
        int[] next = new int[s.length()];
        next[0] = -1;
        int j = -1;
        for (int i = 1; i < s.length(); i++) {
            while (j != -1 && s.charAt(i) != s.charAt(j + 1)) {
                j = next[j];
            }
            if (s.charAt(i) == s.charAt(j + 1)) {
                j++;
            }
            next[i] = j;
        }
        return next;
    }
}
