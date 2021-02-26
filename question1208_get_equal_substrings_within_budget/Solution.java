package question1208_get_equal_substrings_within_budget;

public class Solution {

    public int equalSubstring(String s, String t, int maxCost) {
        int result = 0, left = 0, right = -1, n = s.length(), cost = 0;
        while (right + 1 < n) {
            right++;
            cost += Math.abs(s.charAt(right) - t.charAt(right));
            while (cost > maxCost) {
                cost -= Math.abs(s.charAt(left) - t.charAt(left));
                left++;
            }
            result = Math.max(result, right - left + 1);
        }
        return result;
    }

}