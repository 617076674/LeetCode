package lcci0106_compress_string;

/**
 * 时间复杂度和空间复杂度均是O(n)，其中n为字符串S的长度。
 *
 * 执行用时：5ms，击败88.28%。消耗内存：38.6MB，击败100.00%。
 */
public class Solution {
    public String compressString(String S) {
        int n;
        if (null == S || (n = S.length()) == 0) {
            return S;
        }
        StringBuilder sb = new StringBuilder();
        int count = 0;
        for (int i = 0; i < n; i++) {
            if (i == 0 || (S.charAt(i) != S.charAt(i - 1))) {
                if (i != 0) {
                    sb.append(S.charAt(i - 1)).append(count);
                }
                count = 1;
            } else {
                count++;
            }
        }
        sb.append(S.charAt(n - 1)).append(count);
        if (sb.length() >= n) {
            return S;
        }
        return sb.toString();
    }
}