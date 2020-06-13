package question0727_minimum_window_subsequence;

/**
 * https://www.youtube.com/watch?v=W2DvQcDPD9A
 *
 * 双指针。
 *
 * 执行用时：10ms，击败78.85%。消耗内存：39.7MB，击败100.00%。
 */
public class Solution2 {
    public String minWindow(String S, String T) {
        String result = "";
        int j = 0, minLen = S.length() + 1;
        for (int i = 0; i < S.length(); i++) {
            if (S.charAt(i) == T.charAt(j)) {
                j++;
                if (j >= T.length()) {
                    int end = i + 1;
                    j--;
                    while (j >= 0) {
                        if (T.charAt(j) == S.charAt(i)) {
                            j--;
                        }
                        i--;
                    }
                    i++;
                    j = 0;
                    if (end - i < minLen) {
                        minLen = end - i;
                        result = S.substring(i, end);
                    }
                }
            }
        }
        return result;
    }
}