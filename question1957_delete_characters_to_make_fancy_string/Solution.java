package question1957_delete_characters_to_make_fancy_string;

public class Solution {

    public String makeFancyString(String s) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (sb.length() >= 2 && sb.charAt(sb.length() - 1) == s.charAt(i) && sb.charAt(sb.length() - 2) == s.charAt(i)) {
                continue;
            }
            sb.append(s.charAt(i));
        }
        return sb.toString();
    }

}