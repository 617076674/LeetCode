package question1859_sorting_the_sentence;

public class Solution {
    public String sortSentence(String s) {
        String[] words = new String[10];
        String[] strings = s.split(" ");
        for (String string : strings) {
            int index = string.charAt(string.length() - 1) - '0';
            words[index] = string.substring(0, string.length() - 1);
        }
        StringBuilder sb = new StringBuilder();
        for (String word : words) {
            if (null != word) {
                if (sb.length() > 0) {
                    sb.append(" ");
                }
                sb.append(word);
            }
        }
        return sb.toString();
    }
}