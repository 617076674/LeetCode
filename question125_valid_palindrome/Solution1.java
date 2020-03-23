package question125_valid_palindrome;

public class Solution1 {
    public boolean isPalindrome(String s) {
        s = s.toLowerCase();
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if ((s.charAt(i) >= 'a' && s.charAt(i) <= 'z') || (s.charAt(i) >= '0' && s.charAt(i) <= '9')) {
                stringBuilder.append(s.charAt(i));
            }
        }
        for (int i = 0; i < stringBuilder.length(); i++) {
            if (stringBuilder.charAt(i) != stringBuilder.charAt(stringBuilder.length() - 1 - i)) {
                return false;
            }
        }
        return true;
    }
}