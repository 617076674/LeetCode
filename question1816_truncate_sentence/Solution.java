package question1816_truncate_sentence;

public class Solution {

    public String truncateSentence(String s, int k) {
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ' ') {
                if (count == k - 1) {
                    return s.substring(0, i);
                }
                count++;
            }
        }
        return s;
    }

}