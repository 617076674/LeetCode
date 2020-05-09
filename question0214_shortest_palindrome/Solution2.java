package question0214_shortest_palindrome;

/**
 * KMP算法。
 *
 * 以题给的第一个例子s = "aacecaaa"为例进行分析，首先将s与反转后的s通过"#"进行拼接。
 *
 * 得到tmp = "aacecaaa#aaacecaa"，求tmp的最长相同前后缀（不能是tmp本身）。——KMP算法的next数组的求法。
 *
 * 显然，其最长相同前后缀的值是"aacecaa"，其长度为7，末元素索引是6。原s的长度为8。
 *
 * 只需将s反转后的字符串rev中的第1个字符拼接在s前面即可。
 *
 * 时间复杂度和空间复杂度均是O(n)，其中n为s的长度。
 *
 * 执行用时：68ms，击败52.45%。消耗内存：143.1MB，击败25.00%。
 */
public class Solution2 {
    public String shortestPalindrome(String s) {
        String rev = new StringBuilder(s).reverse().toString();
        return rev.substring(0, rev.length() - longestPrefix(s + "#" + rev)) + s;
    }

    public int longestPrefix(String s) {
        int[][] dp = new int[s.length()][256];
        dp[0][s.charAt(0)] = 1;
        int X = 0;
        for (int i = 1; i < s.length(); i++) {
            for (int j = 0; j < 256; j++) {
                dp[i][j] = dp[X][j];
            }
            dp[i][s.charAt(i)] = i + 1;
            X = dp[X][s.charAt(i)];
        }
        return X;
    }
}