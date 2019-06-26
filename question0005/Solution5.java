package question0005;

/*
 * See analysis: https://blog.csdn.net/qq_41231926/article/details/81865177
 */
public class Solution5 {
    public String longestPalindrome(String s) {
        if (s.length() < 2) {
            return s;
        }
        if (s.length() == 2) {
            if (s.charAt(0) == s.charAt(1)) {
                return s;
            } else {
                return s.substring(0, 1);
            }
        }
        int n = s.length();
        boolean[][] isPalindrome = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            isPalindrome[i][i] = true;
        }
        for (int i = n - 2; i >= 0; i--) {
            for (int j = i + 1; j < n; j++) {
                if (s.charAt(i) == s.charAt(j) && (isPalindrome[i + 1][j - 1] || j - i <= 2)) {
                    isPalindrome[i][j] = true;
                }
            }
        }
        String result = s.substring(0, 1);
        for (int k = -n + 1; k <= -1; k++) {
            for (int i = 0; i < n - 1; i++) {
                if (i - k < n && isPalindrome[i][i - k]) {
                    return s.substring(i, i - k + 1);
                }
            }
        }
        return result;
    }
}
