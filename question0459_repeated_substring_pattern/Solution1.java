package question0459_repeated_substring_pattern;

/**
 * 暴力破解法。
 *
 * 时间复杂度是O(n ^ 2)，其中n为字符串s的长度。空间复杂度是O(n)。
 *
 * 执行用时：19ms，击败89.99%。消耗内存：37.9MB，击败96.30%。
 */
public class Solution1 {
    public boolean repeatedSubstringPattern(String s) {
        int n = s.length();
        for (int i = 2; i <= n; i++) {
            if (n % i == 0) {
                int len = n / i;
                String tmp = s.substring(0, len);
                StringBuilder sb = new StringBuilder();
                for (int j = 0; j < i; j++) {
                    sb.append(tmp);
                }
                if (s.equals(sb.toString())) {
                    return true;
                }
            }
        }
        return false;
    }
}