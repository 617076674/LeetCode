package question0984_string_without_aaa_or_bbb;

public class Solution {
    public String strWithout3a3b(int a, int b) {
        StringBuilder sb = new StringBuilder();
        while (a > 0 || b > 0) {
            if (a == 0) {
                sb.append('b');
                b--;
            } else if (b == 0) {
                sb.append('a');
                a--;
            } else if (a > b) {
                if (sb.length() >= 2 && sb.charAt(sb.length() - 1) == 'a' && sb.charAt(sb.length() - 2) == 'a') {
                    sb.append('b');
                    b--;
                } else {
                    sb.append('a');
                    a--;
                }
            } else {
                if (sb.length() >= 2 && sb.charAt(sb.length() - 1) == 'b' && sb.charAt(sb.length() - 2) == 'b') {
                    sb.append('a');
                    a--;
                } else {
                    sb.append('b');
                    b--;
                }
            }
        }
        return sb.toString();
    }
}