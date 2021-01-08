package question1668_maximum_repeating_substring;

public class Solution {

    public int maxRepeating(String sequence, String word) {
        int result = 0;
        String tmp = word;
        while (tmp.length() <= sequence.length()) {
            if (!sequence.contains(tmp)) {
                break;
            }
            result++;
            tmp += word;
        }
        return result;
    }

}