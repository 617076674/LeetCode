package question0709_to_lower_case;

/**
 * 时间复杂度和空间复杂度均是O(n)，其中n为字符串str的长度。
 *
 * 执行用时：0ms，击败100.00%。消耗内存：34.2MB，击败59.66%。
 */
public class Solution {
    public String toLowerCase(String str) {
        int n;
        if (null == str || (n = str.length()) == 0) {
            return str;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            char c = str.charAt(i);
            if (c >= 'A' && c <= 'Z') {
                sb.append((char) (c - 'A' + 'a'));
            } else {
                sb.append(c);
            }
        }
        return sb.toString();
    }
}
