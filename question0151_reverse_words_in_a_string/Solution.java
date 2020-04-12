package question0151_reverse_words_in_a_string;

/**
 * 时间复杂度和空间复杂度均是O(n)，其中n为字符串s的长度。
 *
 * 执行用时：11ms，击败22.45%。消耗内存：39.4MB，击败5.41%。
 */
public class Solution {
    public String reverseWords(String s) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            while (i < s.length() && s.charAt(i) == ' ') {
                i++;
            }
            StringBuilder sb = new StringBuilder();
            int j = i;
            while (j < s.length() && s.charAt(j) != ' ') {
                sb.append(s.charAt(j));
                j++;
            }
            if (sb.length() != 0 && result.length() != 0) {
                result.insert(0, ' ');
            }
            result.insert(0, sb);
            i = j;
        }
        return result.toString();
    }
}
