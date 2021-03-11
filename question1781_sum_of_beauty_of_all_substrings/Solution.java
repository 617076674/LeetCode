package question1781_sum_of_beauty_of_all_substrings;

public class Solution {

    public int beautySum(String s) {
        int result = 0;
        for (int i = 0; i < s.length(); i++) {
            int[] map = new int[26];
            for (int j = i; j < s.length(); j++) {
                // [i, j]
                map[s.charAt(j) - 'a']++;
                int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
                for (int value : map) {
                    if (value > 0) {
                        min = Math.min(min, value);
                        max = Math.max(max, value);
                    }
                }
                result += max - min;
            }
        }
        return result;
    }

}