package question647;

public class Solution1 {

    public int countSubstrings(String s) {
        int count = 0, len = s.length();
        for (int i = 0; i < len; i++) {
            for (int j = i + 1; j <= len; j++) {
                if (isPalindrom(s.substring(i, j))) {
                    count++;
                }
            }
        }
        return count;
    }

    private boolean isPalindrom(String s) {
        for (int i = 0; i < s.length() / 2; i++) {
            if (s.charAt(i) != s.charAt(s.length() - i - 1)) {
                return false;
            }
        }
        return true;
    }

}
