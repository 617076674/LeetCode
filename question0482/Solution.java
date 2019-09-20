package question0482;

/**
 * 时间复杂度和空间复杂度均是O(n)，其中n为字符串S的长度。
 *
 * 执行用时：20ms，击败88.58%。消耗内存：38MB，击败99.36%。
 */
public class Solution {
    public String licenseKeyFormatting(String S, int K) {
        StringBuilder sb = new StringBuilder();
        S = S.toUpperCase();
        int n = S.length(), len = 0;
        for (int i = n - 1; i >= 0; i--) {
            char c = S.charAt(i);
            if (c == '-') {
                continue;
            }
            if (len < K) {
                sb.append(c);
                len++;
                if (len == K) {
                    sb.append('-');
                    len = 0;
                }
            }
        }
        if (sb.length() > 0 && sb.charAt(sb.length() - 1) == '-') {
            sb.deleteCharAt(sb.length() - 1);
        }
        return sb.reverse().toString();
    }
}
