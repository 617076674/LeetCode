package question151;

public class Solution {
    public String reverseWords(String s) {
        StringBuilder stringBuilder = new StringBuilder();
        String[] strings = s.split("\\s+");
        for (int i = strings.length - 1; i >= 0; i--) {
            stringBuilder.append(strings[i]).append(" ");
        }
        return stringBuilder.toString().trim();
    }
}
