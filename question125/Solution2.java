package question125;

public class Solution2 {
    public boolean isPalindrome(String s) {
        s = s.toLowerCase();
        int left = 0, right = s.length() - 1;
        while (left < right) {
            while (left < right && !isLetterOrNumber(s.charAt(left))) {
                left++;
            }
            while (left < right && !isLetterOrNumber(s.charAt(right))) {
                right--;
            }
            if (s.charAt(left++) != s.charAt(right--)) {
                return false;
            }
        }
        return true;
    }

    private boolean isLetterOrNumber(char c) {
        if (c >= 'a' && c <= 'z') {
            return true;
        } else if (c >= '0' && c <= '9') {
            return true;
        }
        return false;
    }
}
