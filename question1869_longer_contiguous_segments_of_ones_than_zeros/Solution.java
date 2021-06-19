package question1869_longer_contiguous_segments_of_ones_than_zeros;

public class Solution {

    public boolean checkZeroOnes(String s) {
        int len0 = 0, len1 = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '0') {
                int j = i;
                while (j + 1 < s.length() && s.charAt(j + 1) == '0') {
                    j++;
                }
                // [i, j]
                len0 = Math.max(len0, j - i + 1);
                i = j;
            } else {
                int j = i;
                while (j + 1 < s.length() && s.charAt(j + 1) == '1') {
                    j++;
                }
                // [i, j]
                len1 = Math.max(len1, j - i + 1);
                i = j;
            }
        }
        return len1 > len0;
    }

}