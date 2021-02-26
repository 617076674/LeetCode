package question1624_largest_substring_between_two_equal_characters;

public class Solution {

    public int maxLengthBetweenEqualCharacters(String s) {
        int[][] record = new int[26][2];
        for (int i = 0; i < 26; i++) {
            record[i][0] = Integer.MAX_VALUE;   // 最小值
            record[i][1] = Integer.MIN_VALUE;   // 最大值
        }
        for (int i = 0; i < s.length(); i++) {
            int index = s.charAt(i) - 'a';
            record[index][0] = Math.min(i, record[index][0]);
            record[index][1] = Math.max(i, record[index][1]);
        }
        int result = -1;
        for (int i = 0; i < 26; i++) {
            if (record[i][0] != Integer.MAX_VALUE && record[i][1] != Integer.MIN_VALUE) {
                result = Math.max(result, record[i][1] - record[i][0] - 1);
            }
        }
        return result;
    }

}