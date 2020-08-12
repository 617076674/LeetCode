package question1092_shortest_common_supersequence;

/**
 * 时间复杂度和空间复杂度均是 O(n1 * n2)，其中 n1 为字符串 str1 的长度，n2 为字符串 str2 的长度。
 *
 * 执行用时：35ms，击败57.32%。消耗内存：48.7MB，击败50.00%。
 */
public class Solution {
    public String shortestCommonSupersequence(String str1, String str2) {
        //  求字符串 str1 和字符串 str2 的最长公共子序列
        int n1 = str1.length(), n2 = str2.length();
        String[][] dp = new String[n1 + 1][n2 + 1];
        for (int i = 0; i < n1 + 1; i++) {
            dp[i][0] = "";
        }
        for (int i = 0; i < n2 + 1; i++) {
            dp[0][i] = "";
        }
        for (int i = 1; i < n1 + 1; i++) {
            for (int j = 1; j < n2 + 1; j++) {
                if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + str1.charAt(i - 1);
                } else {
                    if (dp[i - 1][j].length() > dp[i][j - 1].length()) {
                        dp[i][j] = dp[i - 1][j];
                    } else {
                        dp[i][j] = dp[i][j - 1];
                    }
                }
            }
        }
        int index1 = 0, index2 = 0;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < dp[n1][n2].length(); i++) {
            char c = dp[n1][n2].charAt(i);
            while (index1 < n1 && str1.charAt(index1) != c) {
                sb.append(str1.charAt(index1++));
            }
            while (index2 < n2 && str2.charAt(index2) != c) {
                sb.append(str2.charAt(index2++));
            }
            sb.append(c);
            index1++;
            index2++;
        }
        return sb.append(str1.substring(index1)).append(str2.substring(index2)).toString();
    }
}