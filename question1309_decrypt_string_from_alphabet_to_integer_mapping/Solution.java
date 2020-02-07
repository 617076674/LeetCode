package question1309_decrypt_string_from_alphabet_to_integer_mapping;

/**
 * 时间复杂度和空间复杂度均是O(n)，其中n为字符串s的长度。
 *
 * 执行用时：2ms，击败64.36%。消耗内存：34.6MB，击败76.35%。
 */
public class Solution {
    public String freqAlphabets(String s) {
        int n;
        if (null == s || (n = s.length()) == 0) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        for (int i = n - 1; i >= 0; i--) {
            char c = s.charAt(i);
            if (c == '#') {
                int num = Integer.parseInt(s.substring(i - 2, i));
                sb.insert(0, (char) (num - 10 + 'j'));
                i -= 2;
            } else {
                int num = Integer.parseInt(s.substring(i, i + 1));
                sb.insert(0, (char) (num - 1 + 'a'));
            }
        }
        return sb.toString();
    }
}