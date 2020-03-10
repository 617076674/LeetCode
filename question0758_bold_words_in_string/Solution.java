package question0758_bold_words_in_string;

/**
 * 时间复杂度是O(m * n)，其中m为words数组的长度，n为字符串S的长度。空间复杂度是O(n)。
 *
 * 执行用时：9ms，击败41.07%。消耗内存：38.4MB，击败8.70%。
 */
public class Solution {
    public String boldWords(String[] words, String S) {
        int n = S.length();
        boolean[] isBold = new boolean[n];
        for (String word : words) {
            int index = S.indexOf(word, 0);
            while (index != -1) {
                for (int i = index; i < index + word.length(); i++) {
                    isBold[i] = true;
                }
                index = S.indexOf(word, index + 1);
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            if (isBold[i] && (i == 0 || !isBold[i - 1])) {
                sb.append("<b>");
            } else if (i > 0 && !isBold[i] && isBold[i - 1]) {
                sb.append("</b>");
            }
            sb.append(S.charAt(i));
        }
        if (isBold[n - 1]) {
            sb.append("</b>");
        }
        return sb.toString();
    }
}