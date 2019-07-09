package question0214;

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
 * 执行用时：11ms，击败73.62%。消耗内存：38.4MB，击败49.02%。
 */
public class Solution3 {
    public String shortestPalindrome(String s) {
        String rev = reverse(s);
        String tmp = s + "#" + rev;
        int[] next = getNext(tmp);
        return rev.substring(0, rev.length() - next[tmp.length() - 1] - 1) + s;
    }

    private String reverse(String s) {
        StringBuilder stringBuilder = new StringBuilder(s);
        return stringBuilder.reverse().toString();
    }

    private int[] getNext(String s) {
        int n = s.length();
        int[] next = new int[n];
        next[0] = -1;
        int j = -1;
        for (int i = 1; i < n; i++) {
            while (j != -1 && s.charAt(i) != s.charAt(j + 1)) {
                j = next[j];
            }
            if (s.charAt(i) == s.charAt(j + 1)) {
                j++;
            }
            next[i] = j;
        }
        return next;
    }
}
