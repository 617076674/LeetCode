package question0838_push_dominoes;

/**
 * 暴力破解法。
 *
 * 时间复杂度是 O(n ^ 2)，其中 n 为字符串 dominoes 的长度。空间复杂度是 O(n)。
 *
 * 执行用时：174ms，击败5.18%。消耗内存：41.6MB，击败14.29%。
 */
public class Solution1 {
    public String pushDominoes(String dominoes) {
        String pre = dominoes;
        int n = dominoes.length();
        while (true) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < n; i++) {
                char c = pre.charAt(i);
                if (c == '.') {
                    if (i == 0) {
                        if (i + 1 < n && pre.charAt(i + 1) == 'L') {
                            sb.append('L');
                        } else {
                            sb.append(c);
                        }
                    } else if (i == n - 1) {
                        if (pre.charAt(i - 1) == 'R') {
                            sb.append('R');
                        } else {
                            sb.append(c);
                        }
                    } else {
                        if (pre.charAt(i - 1) == 'R' && pre.charAt(i + 1) != 'L') {
                            sb.append('R');
                        } else if (pre.charAt(i + 1) == 'L' && pre.charAt(i - 1) != 'R') {
                            sb.append('L');
                        } else {
                            sb.append(c);
                        }
                    }
                } else {
                    sb.append(c);
                }
            }
            if (pre.equals(sb.toString())) {
                return pre;
            }
            pre = sb.toString();
        }
    }
}