package question0557_reverse_words_in_a_string_iii;

/**
 * 执行用时：30ms，击败31.40%。消耗内存：49.3MB，击败52.55%。
 */
public class Solution {
    public String reverseWords(String s) {
        StringBuilder sb = new StringBuilder();
        StringBuilder tmp = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == ' ') {
                sb.append(tmp.reverse()).append(c);
                tmp = new StringBuilder();
            } else {
                tmp.append(c);
            }
        }
        sb.append(tmp.reverse());
        return sb.toString();
    }
}