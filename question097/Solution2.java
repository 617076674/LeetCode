package question097;

/*
 * See analysis: https://blog.csdn.net/qq_41231926/article/details/83309328
 */
public class Solution2 {

    public boolean isInterleave(String s1, String s2, String s3) {
        int n1 = s1.length();
        int n2 = s2.length();
        int n3 = s3.length();
        if (n1 + n2 != n3) {
            return false;
        }
        boolean[][] flags = new boolean[n1 + 1][n2 + 1];
        flags[0][0] = true;
        for (int i = 1; i < n1 + 1; i++) {
            if (!flags[i - 1][0] || s1.charAt(i - 1) != s3.charAt(i - 1)) {
                break;
            }
            flags[i][0] = true;
        }
        for (int i = 1; i < n2 + 1; i++) {
            if (!flags[0][i - 1] || s2.charAt(i - 1) != s3.charAt(i - 1)) {
                break;
            }
            flags[0][i] = true;
        }
        for (int i = 1; i < n1 + 1; i++) {
            for (int j = 1; j < n2 + 1; j++) {
                if (flags[i - 1][j] && s1.charAt(i - 1) == s3.charAt(i + j - 1)) {
                    flags[i][j] = true;
                    continue;
                }
                if (flags[i][j - 1] && s2.charAt(j - 1) == s3.charAt(i + j - 1)) {
                    flags[i][j] = true;
                }
            }
        }
        return flags[n1][n2];
    }
}
