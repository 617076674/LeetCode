package question1653_minimum_deletions_to_make_string_balanced;

public class Solution {

    public int minimumDeletions(String s) {
        int[] countA = new int[s.length() + 1];
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'a') {
                countA[i + 1] = countA[i] + 1;
            } else {
                countA[i + 1] = countA[i];
            }
        }
        int result = Integer.MAX_VALUE;
        for (int i = 0; i <= s.length(); i++) {
            // [0, i - 1] 是 a，[i, s.length() - 1] 是 b
            result = Math.min(result, i - countA[i] + countA[s.length()] - countA[i]);
        }
        return result;
    }

}