package question0738_monotone_increasing_digits;

/**
 * 递归。
 *
 * 332 -> 329 -> 299。
 *
 * 时间复杂度是 O((log(N) ^ 2))。空间复杂度是 O(logN)。
 */
public class Solution1 {

    public int monotoneIncreasingDigits(int N) {
        String num = String.valueOf(N);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < num.length() - 1; i++) {
            if (num.charAt(i + 1) < num.charAt(i)) {
                sb.append((char) (num.charAt(i) - 1));
                for (int j = 0; j < num.length() - i - 1; j++) {
                    sb.append('9');
                }
                return monotoneIncreasingDigits(Integer.parseInt(sb.toString()));
            }
            sb.append(num.charAt(i));
        }
        return N;
    }

}