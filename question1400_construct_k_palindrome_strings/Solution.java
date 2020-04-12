package question1400_construct_k_palindrome_strings;

public class Solution {
    public boolean canConstruct(String s, int k) {
        if (s.length() < k) {
            return false;
        }
        if (s.length() == k) {
            return true;
        }
        int[] count = new int[26];
        for (int i = 0; i < s.length(); i++) {
            count[s.charAt(i) - 'a']++;
        }
        int result = 0;
        for (int i = 0; i < 26; i++) {
            if ((count[i] & 1) == 1) {
                result++;
            }
        }
        return result <= k;
    }
}