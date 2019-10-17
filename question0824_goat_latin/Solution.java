package question0824_goat_latin;

/**
 * 执行用时：3ms，击败93.57%。消耗内存：35.9MB，击败93.64%。
 */
public class Solution {
    public String toGoatLatin(String S) {
        String[] strings = S.split(" ");
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < strings.length; i++) {
            if (i != 0) {
                sb.append(" ");
            }
            sb.append(changeToGoatLatin(strings[i], i + 1));
        }
        return sb.toString();
    }

    private String changeToGoatLatin(String s, int index) {
        StringBuilder sb = new StringBuilder(s);
        char c = s.charAt(0);
        if (c != 'a' && c != 'e' && c != 'i' && c != 'o' && c != 'u' && c != 'A' && c != 'E' && c != 'I' && c != 'O' && c != 'U') {
            sb.deleteCharAt(0);
            sb.append(c);
        }
        sb.append("ma");
        for (int i = 0; i < index; i++) {
            sb.append("a");
        }
        return sb.toString();
    }
}
