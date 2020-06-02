package question1405_longest_happy_string;

/**
 * 贪心算法。
 *
 * 每次在能拼接的字母里选择剩余次数最多的那一个。
 *
 * 时间复杂度是 O(a + b + c)。空间复杂度是 O(1)。
 *
 * 执行用时：1ms，击败84.10%。消耗内存：37.1MB，击败100.00%。
 */
public class Solution {
    private String result = "";

    public String longestDiverseString(int a, int b, int c) {
        longestDiverseString(new StringBuilder(), a, b, c);
        return result;
    }

    private void longestDiverseString(StringBuilder sb, int a, int b, int c) {
        if (sb.length() > result.length()) {
            result = sb.toString();
        }
        int max = Math.max(a, Math.max(b, c));
        if (max == 0) {
            return;
        }
        char c1;
        if (sb.length() < 2 || (c1 = sb.charAt(sb.length() - 1)) != sb.charAt(sb.length() - 2)) {
            if (max == a) {
                sb.append('a');
                longestDiverseString(sb, a - 1, b, c);
            } else if (max == b) {
                sb.append('b');
                longestDiverseString(sb, a, b - 1, c);
            } else {
                sb.append('c');
                longestDiverseString(sb, a, b, c - 1);
            }
        } else {
            if (c1 == 'a') {
                if (b > c) {
                    sb.append('b');
                    longestDiverseString(sb, a, b - 1, c);
                } else {
                    if (c == 0) {
                        return;
                    }
                    sb.append('c');
                    longestDiverseString(sb, a, b, c - 1);
                }
            } else if (c1 == 'b') {
                if (a > c) {
                    sb.append('a');
                    longestDiverseString(sb, a - 1, b, c);
                } else {
                    if (c == 0) {
                        return;
                    }
                    sb.append('c');
                    longestDiverseString(sb, a, b, c - 1);
                }
            } else {
                if (b > a) {
                    sb.append('b');
                    longestDiverseString(sb, a, b - 1, c);
                } else {
                    if (a == 0) {
                        return;
                    }
                    sb.append('a');
                    longestDiverseString(sb, a - 1, b, c);
                }
            }
        }
    }
}