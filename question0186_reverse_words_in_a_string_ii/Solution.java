package question0186_reverse_words_in_a_string_ii;

/**
 * 原地翻转。
 *
 * 对于题给例子：the sky is blue ---> eulb si yks eht ---> blue is sky the
 *
 * 时间复杂度是O(n)，其中n为数组s的长度。空间复杂度是O(1)。
 */
public class Solution {
    public void reverseWords(char[] s) {
        int n;
        if (null == s || (n = s.length) == 0) {
            return;
        }
        for (int i = 0; i < n >> 1; i++) {
            swap(s, i, n - i - 1);
        }
        System.out.println(String.valueOf(s));
        int left = 0, len = 0;
        for (int i = 0; i < n; i++) {
            char c = s[i];
            if (i == n - 1) {
                len++;
                for (int j = left; j < left + (len >> 1); j++) {
                    swap(s, j, (left << 1) + len - 1 - j);
                }
            } else {
                if (c == ' ') {
                    for (int j = left; j < left + (len >> 1); j++) {
                        swap(s, j, (left << 1) + len - 1 - j);
                    }
                    len = 0;
                    left = i + 1;
                } else {
                    len++;
                }
            }
        }
    }

    private void swap(char[] s, int i, int j) {
        char tmp = s[i];
        s[i] = s[j];
        s[j] = tmp;
    }
}