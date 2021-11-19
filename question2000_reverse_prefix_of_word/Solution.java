package question2000_reverse_prefix_of_word;

public class Solution {

    public String reversePrefix(String word, char ch) {
        int index = word.indexOf(ch);
        if (index == -1) {
            return word;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = index; i >= 0; i--) {
            sb.append(word.charAt(i));
        }
        if (index == word.length() - 1) {
            return sb.toString();
        }
        return sb.append(word.substring(index + 1)).toString();
    }

}