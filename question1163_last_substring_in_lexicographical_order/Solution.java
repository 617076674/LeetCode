package question1163_last_substring_in_lexicographical_order;

public class Solution {

    public String lastSubstring(String s) {
        int left = 0, right = 1;
        while (right < s.length()) {
            if (s.charAt(right) < s.charAt(left)) {
                right++;
            } else if (s.charAt(right) > s.charAt(left)) {
                left = right;
                right++;
            } else {
                boolean same = true;
                for (int i = 1; i + right < s.length(); i++) {
                    if (s.charAt(left) < s.charAt(right + i)) {
                        left = right + i;
                        right = left + 1;
                        same = false;
                        break;
                    } else if (s.charAt(left + i) > s.charAt(right + i)) {
                        right++;
                        same = false;
                        break;
                    } else if (s.charAt(left + i) < s.charAt(right + i)) {
                        left = right;
                        right++;
                        same = false;
                        break;
                    }
                }
                if (same) {
                    break;
                }
            }
        }
        return s.substring(left);
    }

}