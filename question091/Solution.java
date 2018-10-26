package question091;

/*
 * See analysis: https://blog.csdn.net/qq_41231926/article/details/83104130
 */
class Solution {
    public int numDecodings(String s) {
        int[] counts = new int[s.length() + 1];

        counts[0] = 1;
        if (s.charAt(0) == '0') {
            return 0;
        }
        counts[1] = 1;
        for (int i = 2; i <= s.length(); i++) {
            if (s.charAt(i - 2) - '0' <= 2) {
                if (s.charAt(i - 2) == '2') {
                    if (s.charAt(i - 1) - '0' <= 6) {
                        if (s.charAt(i - 1) != '0') {
                            counts[i] = counts[i - 1] + counts[i - 2];
                        } else {
                            counts[i] = counts[i - 2];
                        }
                    } else {
                        counts[i] = counts[i - 1];
                    }
                } else if (s.charAt(i - 2) == '1') {
                    if (s.charAt(i - 1) != '0') {
                        counts[i] = counts[i - 1] + counts[i - 2];
                    } else {
                        counts[i] = counts[i - 2];
                    }
                } else {
                    if (s.charAt(i - 1) != '0') {
                        counts[i] = counts[i - 1];
                    } else {
                        counts[i] = 0;
                    }
                }
            } else {
                if (s.charAt(i - 1) == '0') {
                    counts[i] = 0;
                } else {
                    counts[i] = counts[i - 1];
                }
            }
        }
        return counts[s.length()];
    }
}