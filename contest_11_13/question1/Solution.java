package contest_11_13.question1;

public class Solution {

    public boolean checkAlmostEquivalent(String word1, String word2) {
        int[] result1 = word2Array(word1), result2 = word2Array(word2);
        for (int i = 0; i < result1.length; i++) {
            if (Math.abs(result1[i] - result2[i]) > 3) {
                return false;
            }
        }
        return true;
    }

    private static int[] word2Array(String word) {
        int[] result = new int[26];
        for (int i = 0; i < word.length(); i++) {
            result[word.charAt(i) - 'a']++;
        }
        return result;
    }

}