package question0796;

/**
 * @author qianyihui
 * @date 2019-07-12
 *
 * 暴力解法。
 *
 * 时间复杂度是O(n ^ 2)，其中n为字符串A的长度。空间复杂度是O(1)。
 *
 * 执行用时：1ms，击败95.48%。消耗内存：35.6MB，击败48.96%。
 */
public class Solution1 {
    public boolean rotateString(String A, String B) {
        if (A.equals(B)) {
            return true;
        }
        if (A.length() != B.length()) {
            return false;
        }
        for (int i = 0; i < A.length() - 1; i++) {
            A = A.substring(1) + A.charAt(0);
            if (A.equals(B)) {
                return true;
            }
        }
        return false;
    }
}
