package question0392_is_subsequence;

public class Solution1 {
    public boolean isSubsequence(String s, String t) {
        if (s.length() > t.length()) {
            return false;
        }
        int index1 = 0, index2 = 0;
        while (index1 < s.length()) {
            if (s.charAt(index1) == t.charAt(index2)) {
                index1++;
            }
            if (++index2 >= t.length()) {
                return index1 == s.length();
            }
        }
        return true;
    }
}