package question0902_numbers_at_most_n_given_digit_set;

/**
 * 执行用时：1ms，击败74.81%。消耗内存：37.3MB，击败14.29%。
 */
public class Solution {
    private boolean[] set = new boolean[9];

    private int[] lessMap = new int[9];

    public int atMostNGivenDigitSet(String[] D, int N) {
        String stringN = String.valueOf(N);
        int n = stringN.length(), result = 0;
        for (int i = 1; i <= n - 1; i++) {
            result += Math.pow(D.length, i);
        }
        for (String s : D) {
            set[s.charAt(0) - '1'] = true;
        }
        for (int i = 0; i < 9; i++) {
            char c = (char) ('1' + i);
            for (String s : D) {
                if (c > s.charAt(0)) {
                    lessMap[c - '1']++;
                }
            }
        }
        result += atMostNGivenDigitSet(D, stringN, 0);
        return result;
    }

    private int atMostNGivenDigitSet(String[] D, String stringN, int index) {
        if (index == stringN.length()) {
            return 1;
        }
        char c = stringN.charAt(index);
        int result = 0;
        if (c != '0' && set[c - '1']) {
            result += atMostNGivenDigitSet(D, stringN, index + 1);
        }
        if (c != '0') {
            result += lessMap[c - '1'] * Math.pow(D.length, stringN.length() - index - 1);
        }
        return result;
    }
}