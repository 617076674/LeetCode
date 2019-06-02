package question647;

public class Solution3 {

    private int result = 0;

    public int countSubstrings(String s) {
        for (int i = 0; i < s.length(); i++) {
            countSubstrings(s, i, i);               //回文串长度为奇数
            countSubstrings(s, i, i + 1);     //回文串长度为偶数
        }
        return result;
    }

    private void countSubstrings(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
            result++;
        }
    }

}
